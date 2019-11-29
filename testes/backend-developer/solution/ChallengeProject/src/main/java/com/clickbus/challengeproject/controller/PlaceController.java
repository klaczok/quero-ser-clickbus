package com.clickbus.challengeproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickbus.challengeproject.event.ResourceCreatedEvent;
import com.clickbus.challengeproject.model.Place;
import com.clickbus.challengeproject.repository.filter.PlaceFilter;
import com.clickbus.challengeproject.service.PlaceService;

/**
 * 
 * @author Rafael Klaczok
 *
 */

@RestController
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	PlaceService placeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/")
	public List<Place> listAll(){
		return placeService.listAll();
	}
	
	@GetMapping
	public List<Place> listByName(PlaceFilter placeFilter, Pageable pageable){
		return placeService.filterByName(placeFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Place> findById(@PathVariable long id){
		try {
		return ResponseEntity.ok(placeService.findById(id));
		}catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place){
		try {
			Place placeSave = placeService.update(id, place);
			return ResponseEntity.ok(placeSave);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping
	public ResponseEntity<Place> createPlace(@Valid @RequestBody Place place, HttpServletResponse response){
		Place savePlace = placeService.savePlace(place);
		publisher.publishEvent(new ResourceCreatedEvent(this, savePlace.getId(), response));
		return ResponseEntity.status(HttpStatus.CREATED).body(savePlace);
		
	}
	
}
