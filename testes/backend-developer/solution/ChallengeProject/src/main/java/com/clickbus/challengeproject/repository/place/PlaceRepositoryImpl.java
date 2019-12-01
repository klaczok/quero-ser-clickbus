package com.clickbus.challengeproject.repository.place;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.clickbus.challengeproject.model.Place;
import com.clickbus.challengeproject.model.PlaceMetaModel;
import com.clickbus.challengeproject.repository.filter.PlaceFilter;

public class PlaceRepositoryImpl implements PlaceRepositoryQuery{

	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	public List<Place> filterByName(PlaceFilter placeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Place> criteria = builder.createQuery(Place.class);
		Root<Place> root = criteria.from(Place.class);
		
		//Create predicates
		Predicate[] predicates = createRestrictions(placeFilter, builder, root);
		criteria.where(predicates);
		TypedQuery<Place> query = manager.createQuery(criteria);
		
		
		return query.getResultList() ;
		
		
		
		
		
	}


	
	private Predicate[] createRestrictions(PlaceFilter placeFilter, CriteriaBuilder builder, Root<Place> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(!StringUtils.isEmpty(placeFilter.getName())) {
			predicates.add(
					builder.like(builder.lower(root.get(PlaceMetaModel.name)), "%" + placeFilter.getName().toLowerCase()+"%")
					);
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	


}
