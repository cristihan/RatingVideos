package com.ratingVideo.applicationDTO;

import com.ratingVideo.domain.Rating;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

public class RatingDTO {
	
	private int valoracion;
	private String comentario;
	
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
