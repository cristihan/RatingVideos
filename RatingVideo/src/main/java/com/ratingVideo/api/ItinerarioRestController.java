package com.ratingVideo.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ratingVideo.application.ItinerarioController;
import com.ratingVideo.applicationDTO.ItinerarioDTO;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

public class ItinerarioRestController {

	private ItinerarioController controller;

	private String toJson(Object object) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);

	}

	// POST: /itinerarios : crea un itinerario
	@PostMapping(value = "/itinerarios", produces = "application/json;charset=UTF-8")
	public String createItinerari(@RequestBody String jItinerario) throws InvalidParamException, NotFoundException {
		ItinerarioDTO newItinerario = new Gson().fromJson(jItinerario, ItinerarioDTO.class);
		ItinerarioDTO itinerario = controller.createItinerario(newItinerario);
		return toJson(itinerario);
	}

	// GET /players/: retorna el llistat de tots els itinerarios del sistema 	
	@GetMapping(value = "/itinerarios", produces = "application/json;charset=UTF-8")
	public String getListItinerario() throws NotFoundException, InvalidParamException {
		List<ItinerarioDTO> itinerario = controller.getAllItinerarios();
		return toJson(itinerario);
	}

}
