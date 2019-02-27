package com.ratingVideo.persistence;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ratingVideo.domain.Video;

interface  HelperVideoRepository extends CrudRepository<Video, Integer> {
	List<Video> findByItineraryCode(String itineraryID);
	
}
