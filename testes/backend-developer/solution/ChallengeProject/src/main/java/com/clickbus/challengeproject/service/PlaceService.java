package com.clickbus.challengeproject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clickbus.challengeproject.exceptions.InvalidFieldsSendException;
import com.clickbus.challengeproject.model.Place;
import com.clickbus.challengeproject.repository.PlaceRepository;
import com.clickbus.challengeproject.repository.filter.PlaceFilter;

@Service
public class PlaceService {
	
	@Autowired
	PlaceRepository placeRepository;
	
	public List<Place> listAll(){
		return placeRepository.findAll();
	}
	
	public List<Place> filterByName(PlaceFilter placeFilter){
		return placeRepository.filterByName(placeFilter);
	}

	public Place findById(long id) {
		return findOptionalObject(id);		
	}

	private Place findOptionalObject(long id) {
		Optional<Place> place = placeRepository.findById(id);
		return place.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Place update(Long id, Place place) {
		validationDateFields(place);
		Place placeSave = findOptionalObject(id);	
		validationField(place, placeSave);
		updateTime(place);
		BeanUtils.copyProperties(place, placeSave, "id", "createdAt" );		
		return placeRepository.save(placeSave);		
	}


	public Place updateTime(Place place) {	
		place.setUpdatedAt(new Date());
		return place;
	}

	public Place savePlace(@Valid Place place) {
		validationDateFields(place);
		createdTime(place);
		return placeRepository.save(place);		
	}
	
	public Place createdTime(Place place) {	
		place.setCreatedAt(new Date());
		return place;
	}
	
	private void validationField(Place place, Place placeSave) {		
		place.setName(place.getName() != null ? place.getName() : placeSave.getName());
		place.setSlug(place.getSlug() != null ? place.getSlug() : placeSave.getSlug());
		place.setCity(place.getCity() != null ? place.getCity() : placeSave.getCity());
		place.setState(place.getState() != null ? place.getState() : placeSave.getState());
	}
	
	public void validationDateFields(Place place) {
		if(place.getCreatedAt()!= null || place.getUpdatedAt()!= null) {
			throw new InvalidFieldsSendException();
		}
	}


}
