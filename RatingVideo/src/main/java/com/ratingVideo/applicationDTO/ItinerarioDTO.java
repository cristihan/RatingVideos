package com.ratingVideo.applicationDTO;

import java.util.ArrayList;
import java.util.List;

import com.ratingVideo.domain.Itinerario;
import com.ratingVideo.domain.Video;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

public class ItinerarioDTO {
	
	private String itinerarioId;
	private String nameItinerario;
	private List<VideoDTO> allVideos = new ArrayList<VideoDTO>();
	
	public ItinerarioDTO() {
		
	}
	
	public ItinerarioDTO(Itinerario itinerario) throws InvalidParamException, NotFoundException {
		if(itinerario == null)
			throw new NotFoundException();
		
		this.itinerarioId = itinerario.getItinerarioId();
		this.nameItinerario = itinerario.getNameItinerario();
		this.allVideos = convertToDTO(itinerario.getAllVideos());
		 
	}
	
	private List<VideoDTO> convertToDTO(List<Video> allVideos) throws InvalidParamException, NotFoundException{
		List<VideoDTO> results = new ArrayList<>();
		for (Video  v: allVideos) {
			results.add(new VideoDTO(v));
		}
		return results;
		
	}

	public String getItinerarioId() {
		return itinerarioId;
	}

	public String getNameItinerario() {
		if(nameItinerario == null)
			return "";
		return nameItinerario;
	}

	public List<VideoDTO> getAllVideos() {
		return allVideos;
	}
	
	

}
