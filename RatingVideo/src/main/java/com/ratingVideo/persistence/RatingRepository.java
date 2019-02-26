package com.ratingVideo.persistence;

import com.ratingVideo.domain.Rating;
import com.ratingVideo.utilities.InvalidParamException;

public class RatingRepository {

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
