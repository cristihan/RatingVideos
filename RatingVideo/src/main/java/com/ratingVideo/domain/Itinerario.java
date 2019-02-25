package com.ratingVideo.domain;

import java.util.ArrayList;
import java.util.List;

import com.ratingVideo.applicationDTO.ItinerarioDTO;
import com.ratingVideo.utilities.InvalidParamException;

public class Itinerario {
	
	private Integer itinerarioId;
	private String nameItinerario;
	private List<Video> allVideos = new ArrayList<Video>();
	
	public Itinerario() {
		
	}
	
	public Itinerario(ItinerarioDTO itinerarioDto) throws InvalidParamException {
		if(itinerarioDto == null)
			throw new InvalidParamException();
		
		this.itinerarioId = itinerarioDto.getItinerarioId();
		this.nameItinerario = itinerarioDto.getNameItinerario();
	}
	

	public Integer getItinerarioId() {
		return itinerarioId;
	}

	public String getNameItinerario() {
		return nameItinerario;
	}

	public List<Video> getAllVideos() {
		return allVideos;
	}
	
	public void addVideo(Video video) {
		this.allVideos.add(video);
	}
	
	public void deleteVideo() {
		this.allVideos = new ArrayList<Video>();
	}
	
	
	
	

}
