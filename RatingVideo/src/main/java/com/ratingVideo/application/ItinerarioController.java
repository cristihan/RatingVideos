package com.ratingVideo.application;

import java.util.ArrayList;
import java.util.List;

import com.ratingVideo.applicationDTO.ItinerarioDTO;
import com.ratingVideo.domain.Itinerario;
import com.ratingVideo.persistence.ItinerarioRepository;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;
import com.ratingVideo.utilities.WrongItineraryException;

public class ItinerarioController {
	
	private ItinerarioRepository itinerarioRepository;
	
	public ItinerarioDTO createItinerario(ItinerarioDTO itinerarioDto) throws InvalidParamException, NotFoundException {
		Itinerario itinerario = new Itinerario(itinerarioDto);
	
		itinerarioRepository.saveItinerario(itinerario);		
		return new ItinerarioDTO(itinerario);
	}
	
	
	public List<ItinerarioDTO> getAllItinerarios() throws NotFoundException, InvalidParamException  {
		List<ItinerarioDTO> itinerarioDTOList = new ArrayList<>();
		List<Itinerario> itinerarioList = itinerarioRepository.getAllItinerarios();
		
		if (itinerarioList.isEmpty())
			throw new NotFoundException();

		for (Itinerario i : itinerarioList) {
			itinerarioDTOList.add(new ItinerarioDTO(i));
		}

		return itinerarioDTOList;
	}
	
	
	private void containItinerario(String itinerarioId) throws WrongItineraryException {
		if (!Itinerario.ALLITINERARIOS.contains(itinerarioId));
			throw new WrongItineraryException();
	}
	
	Itinerario getAllItinerarioId(String itinerarioId) throws WrongItineraryException, InvalidParamException {
		containItinerario(itinerarioId);
		Itinerario itinerario = new Itinerario();
		itinerarioRepository.saveItinerario(itinerario);
		return itinerario;
		// Itinerario itinerario = itinerarioRepository.getItinerarioById(itinerarioId);
		// return itinerario;
	}

}
