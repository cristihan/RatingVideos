package com.ratingVideo.applicationDTO;

import com.google.gson.annotations.Expose;
import com.ratingVideo.domain.Itinerario;
import com.ratingVideo.domain.Rating;
import com.ratingVideo.domain.Video;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

public class RatingDTO {
	
	@Expose
	private int valoracion;
	@Expose
	private String comentario;
	
	@Expose
	private Video video;
	
	public RatingDTO() {
		
	}
	
	public RatingDTO(Rating rating) throws InvalidParamException, NotFoundException {
		if(rating == null)
			throw new NotFoundException();
		
		this.valoracion = rating.getValoracion();
		this.comentario = rating.getComentario();
	}

	public int getValoracion() throws InvalidParamException {
		if(valoracion >=0 && valoracion <=5)
		return valoracion;
		throw new InvalidParamException();
	}

	public String getComentario() {
		return comentario;
	}
	
	

}
