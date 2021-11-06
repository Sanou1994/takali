package com.connecsen.oterrain.exception.createexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreateReservationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CreateReservationException(String equipe) {
        super(String.format("reservation  with name is '%s' not found", equipe));
    }
}
