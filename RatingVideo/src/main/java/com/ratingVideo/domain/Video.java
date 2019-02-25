package com.ratingVideo.domain;

import java.util.ArrayList;
import java.util.List;

import com.ratingVideo.applicationDTO.VideoDTO;
import com.ratingVideo.utilities.InvalidParamException;

public class Video {
	
	private Integer videoId;
	private String nameVideo;
	private List<Rating> allRatings = new ArrayList<Rating>();
	
	public Video() {
		
	}
	
	public Video(VideoDTO videoDto) throws InvalidParamException {
		if(videoDto == null)
			throw new InvalidParamException();
		
		this.videoId = videoDto.getVideoId();
		this.nameVideo = videoDto.getNameVideo();		
	}

	public Integer getVideoId() {
		return videoId;
	}

	public String getNameVideo() {
		return nameVideo;
	}

	public List<Rating> getAllRatings() {
		return allRatings;
	}
	
	public void addRating(Rating rating) {
		this.allRatings.add(rating);
	}
	
	public void deleteRating() {
		this.allRatings = new ArrayList<Rating>();
	}

}
