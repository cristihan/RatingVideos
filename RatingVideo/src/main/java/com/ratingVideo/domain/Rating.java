package com.ratingVideo.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ratingVideo.applicationDTO.RatingDTO;
import com.ratingVideo.utilities.InvalidParamException;


@Entity(name = "Rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "rating_Id")
	private Integer ratingId;
	@Column(name = "valoracion")
	private int valoracion;
	@Column(name = "comentario")
	private String comentario;
	
	@ManyToOne(targetEntity = Video.class)
	private Video video;

	
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
