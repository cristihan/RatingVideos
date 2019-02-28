package com.ratingVideo.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratingVideo.domain.Rating;
import com.ratingVideo.utilities.InvalidParamException;

@Repository
public class RatingRepository {
	
	@Autowired
	private HelperRatingRepository repository;

	public void saveRating(Rating rating) throws InvalidParamException {
		if (rating == null)
			throw new InvalidParamException();
		try {
			repository.save(rating);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}

}
