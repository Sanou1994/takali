package com.connecsen.oterrain.exception.nofoundexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FichierNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public FichierNotFoundException(Long username) {
        super(String.format("fichier with id '%s' not found", username));
    }
}
