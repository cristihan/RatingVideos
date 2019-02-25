package com.ratingVideo.persistence;



import org.springframework.data.repository.CrudRepository;

import com.ratingVideo.domain.Video;

interface  HelperVideoRepository extends CrudRepository<Video, Integer> {
	
	
}
