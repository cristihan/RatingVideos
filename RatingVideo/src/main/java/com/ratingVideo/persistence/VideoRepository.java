package com.ratingVideo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.ratingVideo.domain.Rating;
import com.ratingVideo.domain.Video;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

@Repository
public class VideoRepository {
	
	@Autowired
	private HelperVideoRepository repository;


	public void saveVideo(Video video) throws InvalidParamException {
		if (video == null)
			throw new InvalidParamException();
		try {
			repository.save(video);
		} catch (Exception e) {
			throw new InvalidParamException();
		}

	}
	

	public List<Video> getAllVideos() {
		List<Video> result = new ArrayList<>();
		for (Video v : repository.findAll()) {
			result.add(v);
		}
		return result;
	}

	public Video getVideoById(int videoId) throws NotFoundException {
		try {
			return repository.findById(videoId).get();
		} catch (Exception exception) {
			throw new NotFoundException();
		}

	}

}
