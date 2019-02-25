package com.ratingVideo.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ratingVideo.application.VideoController;
import com.ratingVideo.applicationDTO.RatingDTO;
import com.ratingVideo.applicationDTO.VideoDTO;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

public class VideoRestController {
	
	private VideoController controller;

	private String toJson(Object object) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);

	}

	// POST: /Videos : crea un Video
	@PostMapping(value = "/videos", produces = "application/json;charset=UTF-8")
	public String createVideo(@PathVariable int itinerarioId, @RequestBody String jVideo) throws InvalidParamException, NotFoundException {
		VideoDTO newVideo = new Gson().fromJson(jVideo, VideoDTO.class);
		VideoDTO video = controller.createVideo(itinerarioId, newVideo);
		return toJson(video);
	}
	
	@PostMapping(value = "/videos/{videoId}/rating", produces = "application/json;charset=UTF-8")
	public String createRating(@PathVariable int videoId, @RequestBody String jRating) throws InvalidParamException, NotFoundException {
		RatingDTO newReating = new Gson().fromJson(jRating, RatingDTO.class);
		RatingDTO reating = controller.createRating(videoId, newReating);
		return toJson(reating);
	}

	// GET /Videos/: retorna el llistat de tots els videos del sistema 	
	@GetMapping(value = "/videos", produces = "application/json;charset=UTF-8")
	public String getListVideo() throws NotFoundException, InvalidParamException {
		List<VideoDTO> video = controller.getAllVideos();
		return toJson(video);
	}

}
