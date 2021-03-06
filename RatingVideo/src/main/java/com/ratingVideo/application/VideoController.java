package com.ratingVideo.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.ratingVideo.applicationDTO.RatingDTO;
import com.ratingVideo.applicationDTO.VideoDTO;
import com.ratingVideo.domain.Itinerario;
import com.ratingVideo.domain.Rating;
import com.ratingVideo.domain.Video;
import com.ratingVideo.persistence.ItinerarioRepository;
import com.ratingVideo.persistence.RatingRepository;
import com.ratingVideo.persistence.VideoRepository;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;
import com.ratingVideo.utilities.WrongItineraryException;

@Controller
public class VideoController {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private ItinerarioRepository itinerarioRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private ItinerarioController controller;

	public VideoDTO createVideo(String itinerarioId, VideoDTO videoDto)
			throws InvalidParamException, NotFoundException, WrongItineraryException {
		Itinerario itinerario = controller.getAllItinerarioId(itinerarioId);
		// containItinerario(itinerarioId);
		// Itinerario itinerario = itinerarioRepository.getItinerarioById(itinerarioId);
		Video video = new Video(videoDto);
		//itinerario.addVideo(video);
		videoRepository.saveVideo(video);
		itinerarioRepository.saveItinerario(itinerario);

		return new VideoDTO(video);
	}

	public RatingDTO createRating(int videoId, RatingDTO ratingDto) throws InvalidParamException, NotFoundException {
		Video video = videoRepository.getVideoById(videoId);
		Rating rating = new Rating(ratingDto);
		//video.addRating(rating);
		ratingRepository.saveRating(rating);
		videoRepository.saveVideo(video);

		return new RatingDTO(rating);
	}

	public List<VideoDTO> getAllVideos() throws NotFoundException, InvalidParamException {
		List<VideoDTO> videoDTOList = new ArrayList<>();

		List<Video> videoList = videoRepository.getAllVideos();

		if (videoList.isEmpty())
			throw new NotFoundException();

		for (Video v : videoList) {
			videoDTOList.add(new VideoDTO(v));
		}

		return videoDTOList;
	}

	Video getVideoId(int videoId) throws NotFoundException {
		Video video = videoRepository.getVideoById(videoId);
		return video;
	}

}
