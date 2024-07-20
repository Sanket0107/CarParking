package com.parkingLot.car_parking_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException() {
		super();
	}

	public CustomException( String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
