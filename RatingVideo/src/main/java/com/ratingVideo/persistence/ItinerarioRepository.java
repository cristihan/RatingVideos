package com.ratingVideo.persistence;


import java.util.ArrayList;
import java.util.List;


import com.ratingVideo.domain.Itinerario;
import com.ratingVideo.utilities.InvalidParamException;
import com.ratingVideo.utilities.NotFoundException;

public class ItinerarioRepository {

	private HelperItinerarioRepository repository;

	public void saveItinerario(Itinerario itinerario) throws InvalidParamException {
		if (itinerario == null)
			throw new InvalidParamException();
		try {
			repository.save(itinerario);
		} catch (Exception e) {
			throw new InvalidParamException();
		}

	}

	public List<Itinerario> getAllItinerarios() {
		List<Itinerario> result = new ArrayList<>();
		for (Itinerario p : repository.findAll()) {
			result.add(p);
		}
		return result;
	}

	public Itinerario getItinerarioById(int itinerarioId) throws NotFoundException {
		try {
			return repository.findById(itinerarioId).get();
		} catch (Exception exception) {
			throw new NotFoundException();
		}

	}

}
