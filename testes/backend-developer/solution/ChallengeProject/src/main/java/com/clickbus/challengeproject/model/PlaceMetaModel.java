package com.clickbus.challengeproject.model;

import java.time.LocalTime;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * 
 * @author Rafael Klaczok
 *
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Place.class)
public abstract class PlaceMetaModel {
	public static volatile SingularAttribute<Place, Long> id;
	public static volatile SingularAttribute<Place, String> name;
	public static volatile SingularAttribute<Place, String> slug;
	public static volatile SingularAttribute<Place, String> city;
	public static volatile SingularAttribute<Place, String> state;
	public static volatile SingularAttribute<Place, LocalTime> createdAt;
	public static volatile SingularAttribute<Place, LocalTime> updatedAt;

}
