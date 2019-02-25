package com.ratingVideo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ratingVideo.domain.Itinerario;






// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

interface HelperItinerarioRepository extends CrudRepository<Itinerario, Integer> {

//	@Transactional
//	void removeByPlayer(Player player);
//
//	@Transactional
//	void updateByPlayer(String name);

}
