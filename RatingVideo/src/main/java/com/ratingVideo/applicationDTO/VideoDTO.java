package com.ratingVideo.applicationDTO;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.ratingVideo.domain.Itinerario;
import com.ratingVideo.domain.Rating;
import com.ratingVideo.domain.Video;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;



public class VideoDTO {
	
	@Expose
	private int videoId;
	@Expose
	private String nameVideo;
	
	@Expose
	private Itinerario itinerario;
	
//	@Expose
//	private List<RatingDTO> allRatings = new ArrayList<RatingDTO>();
	
	public VideoDTO() {
		
	}
	
	public VideoDTO(Video video) throws InvalidParamException, NotFoundException {
		if(video == null)
			throw new NotFoundException();
		
		this.videoId = video.getVideoId();
		this.nameVideo = video.getNameVideo();
//		this.allRatings = convertToDTO(video.getAllRatings());
	}
	
//	private List<RatingDTO> convertToDTO(List<Rating> allRatings) throws InvalidParamException, NotFoundException{
//		List<RatingDTO> results = new ArrayList<>();
//		for (Rating  r: allRatings) {
//			results.add(new RatingDTO(r));
//		}
//		return results;
//		
//	}

	public int getVideoId() {
		return videoId;
	}

	public String getNameVideo() {
		return nameVideo;
	}

//	public List<RatingDTO> getAllRatings() {
//		return allRatings;
//	}
//	
	

}
