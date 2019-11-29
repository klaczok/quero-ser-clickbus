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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.clickbus.challengeproject.model.Place;
import com.clickbus.challengeproject.model.Place_;
import com.clickbus.challengeproject.repository.filter.PlaceFilter;

public class PlaceRepositoryImpl implements PlaceRepositoryQuery{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Place> filterByName(PlaceFilter placeFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Place> criteria = builder.createQuery(Place.class);
		Root<Place> root = criteria.from(Place.class);
		
		//Create predicates
		Predicate[] predicates = createRestrictions(placeFilter, builder, root);
		criteria.where(predicates);
		TypedQuery<Place> query = manager.createQuery(criteria);
		
		getRestictionsToPage(query, pageable);
		
		
		return query.getResultList() ;
		
		
	}

	private Long total(PlaceFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		
		Root<Place> root = criteria.from(Place.class);
		Predicate[] predicates = createRestrictions(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
	private Predicate[] createRestrictions(PlaceFilter placeFilter, CriteriaBuilder builder, Root<Place> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(!StringUtils.isEmpty(placeFilter.getName())) {
			predicates.add(
					builder.like(builder.lower(root.get(Place_.name)), "%" + placeFilter.getName().toLowerCase()+"%")
					);
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void getRestictionsToPage(TypedQuery<?> query, Pageable pageable) {
		int paginaAtula = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroPagina = paginaAtula * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistrosPorPagina);
		
	}

}
