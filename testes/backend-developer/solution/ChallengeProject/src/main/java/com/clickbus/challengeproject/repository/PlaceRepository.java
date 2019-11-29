package com.clickbus.challengeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickbus.challengeproject.model.Place;
import com.clickbus.challengeproject.repository.place.PlaceRepositoryQuery;
/**
 * 
 * @author Rafael Klaczok
 *
 */
public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceRepositoryQuery{
	

}
