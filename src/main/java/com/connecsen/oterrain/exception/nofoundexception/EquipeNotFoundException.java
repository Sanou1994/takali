package com.connecsen.oterrain.exception.nofoundexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EquipeNotFoundException(Long username) {
        super(String.format("equipe with id '%s' not found", username));
    }
}
