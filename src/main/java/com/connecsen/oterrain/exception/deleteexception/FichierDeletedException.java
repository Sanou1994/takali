package com.connecsen.oterrain.exception.deleteexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FichierDeletedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public FichierDeletedException(Long id) {
        super(String.format("fichier with id '%s' can't deleted", id));
    }
}
