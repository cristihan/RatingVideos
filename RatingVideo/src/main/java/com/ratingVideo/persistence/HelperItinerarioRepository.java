package com.ratingVideo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ratingVideo.domain.Itinerario;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

interface HelperItinerarioRepository extends CrudRepository<Itinerario, Integer> {



}
