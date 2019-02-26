package com.ratingVideo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ratingVideo.domain.Rating;

interface HelperRatingRepository extends CrudRepository<Rating, Integer> {

}
