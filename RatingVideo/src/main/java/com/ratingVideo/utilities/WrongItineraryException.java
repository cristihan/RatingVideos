package com.ratingVideo.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Wrong Itinerary Code")
public class WrongItineraryException extends Exception {


	private static final long serialVersionUID = 4390842480462361661L;

}
