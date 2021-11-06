package com.connecsen.oterrain.exception.deleteexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ReservationDeletedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ReservationDeletedException(Long id) {
        super(String.format("reservation with id '%s' can't deleted", id));
    }
}
