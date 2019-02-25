package com.ratingVideo.domain;

import com.ratingVideo.applicationDTO.RatingDTO;
import com.ratingVideo.utilities.InvalidParamException;

public class Rating {
	
	private int valoracion;
	private String comentario;
	
	public Rating() {
		
	}
	
	public Rating(RatingDTO ratingDto) throws InvalidParamException {
		if(ratingDto == null)
			throw new InvalidParamException();
		
		this.valoracion = ratingDto.getValoracion();
		this.comentario = ratingDto.getComentario();
		
	}

	public int getValoracion() {
		return valoracion;
	}

	public String getComentario() {
		return comentario;
	}
	
	

}
