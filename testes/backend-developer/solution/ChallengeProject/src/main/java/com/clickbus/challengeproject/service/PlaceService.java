package com.clickbus.challengeproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	
	public List<Place> filterByName(PlaceFilter placeFilter, Pageable pageable){
		return placeRepository.filterByName(placeFilter, pageable);
	}

	public Place findById(long id) {
		return findOptionalObject(id);
		
		
	}

	private Place findOptionalObject(long id) {
		Optional<Place> place = placeRepository.findById(id);
		return place.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Place update(Long id, Place place) {
		Place placeUpdate = findOptionalObject(id);
		BeanUtils.copyProperties(place, placeUpdate, "id");				
		placeRepository.save(placeUpdate);
		return updateTime(id, placeUpdate);
		
	}
	
	public Place updateTime(Long id, Place place) {
		Place placeUpdate = findOptionalObject(id);		
		placeUpdate.setUpdatedAt(LocalDate.now());
		return placeRepository.save(placeUpdate);
	}

	public Place savePlace(@Valid Place place) {
		place.setCreatedAt(LocalDate.now());
		return placeRepository.save(place);
		
	}
	


}
