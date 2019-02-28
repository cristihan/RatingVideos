package com.ratingVideo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.ratingVideo.applicationDTO.ItinerarioDTO;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.WrongItineraryException;

@Entity(name = "Itinerario")
public class Itinerario {

	@Id
	@Column(name = "itinerario_Id")
	private String itinerarioId;
	@Column(name = "name_Itinerario")
	private String nameItinerario;	

	public static final String BE = "BE";
	public static final String FE = "FE";
	public static final String AD = "AD";
	@Transient
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

	

}
