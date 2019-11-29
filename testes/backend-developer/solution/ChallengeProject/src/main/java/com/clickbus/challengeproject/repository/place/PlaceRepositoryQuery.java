package com.clickbus.challengeproject.repository.place;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.clickbus.challengeproject.model.Place;
import com.clickbus.challengeproject.repository.filter.PlaceFilter;

public interface PlaceRepositoryQuery {

	public List<Place> filterByName(PlaceFilter placeFilter, Pageable pageable);
}
