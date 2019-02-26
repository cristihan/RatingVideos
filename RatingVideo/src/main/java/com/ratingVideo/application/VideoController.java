package com.ratingVideo.application;

import java.util.ArrayList;
import java.util.List;

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

public class VideoController {
	
private VideoRepository videoRepository;

private ItinerarioRepository itinerarioRepository;

private RatingRepository ratingRepository;
	
	public VideoDTO createVideo(int itinerarioId, VideoDTO videoDto) throws InvalidParamException, NotFoundException {
		Itinerario itinerario = itinerarioRepository.getItinerarioById(itinerarioId);
		Video video = new Video(videoDto);
		itinerario.addVideo(video);
		videoRepository.saveVideo(video);
		itinerarioRepository.saveItinerario(itinerario);
		
		return new VideoDTO(video);
	}
	
	
	public RatingDTO createRating(int videoId, RatingDTO ratingDto) throws InvalidParamException, NotFoundException {
		Video video = videoRepository.getVideoById(videoId);
		Rating rating = new Rating(ratingDto);
		video.addRating(rating);
		ratingRepository.saveRating(rating);
		videoRepository.saveVideo(video);
		
		return new RatingDTO(rating);
	}
	
	
	public List<VideoDTO> getAllVideos() throws NotFoundException, InvalidParamException  {
		List<VideoDTO> videoDTOList = new ArrayList<>();
		List<Video> videoList = videoRepository.getAllVideos();
		
		if (videoList.isEmpty())
			throw new NotFoundException();

		for (Video v : videoList) {
			videoDTOList.add(new VideoDTO(v));
		}

		return videoDTOList;
	}
	
	Video getVideoId(int videoId) throws NotFoundException  {
		Video video = videoRepository.getVideoById(videoId);
		return video;
	}

}
