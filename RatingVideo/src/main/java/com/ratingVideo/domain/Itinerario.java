package com.ratingVideo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ratingVideo.applicationDTO.ItinerarioDTO;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.WrongItineraryException;

public class Itinerario {

	private String itinerarioId;
	private String nameItinerario;
	private List<Video> allVideos = new ArrayList<Video>();

	public static final String BE = "BE";
	public static final String FE = "FE";
	public static final String AD = "AD";
	public static final List<String> ALLITINERARIOS = Arrays.asList(BE, FE, AD);

	public Itinerario() {

	}

	public Itinerario(ItinerarioDTO itinerarioDto) throws InvalidParamException {
		if (itinerarioDto == null)
			throw new InvalidParamException();

		this.itinerarioId = itinerarioDto.getItinerarioId();
		this.nameItinerario = itinerarioDto.getNameItinerario();
	}

	public void containItinerario(String itinerarioId) throws WrongItineraryException {
		if (!ALLITINERARIOS.contains(itinerarioId))
			throw new WrongItineraryException();
		this.itinerarioId = itinerarioId;

	}

	public String getItinerarioId() {
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
