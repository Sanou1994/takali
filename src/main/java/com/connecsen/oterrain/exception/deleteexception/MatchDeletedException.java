package com.connecsen.oterrain.exception.deleteexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MatchDeletedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MatchDeletedException(Long id) {
        super(String.format("match with id '%s' can't deleted", id));
    }
}
