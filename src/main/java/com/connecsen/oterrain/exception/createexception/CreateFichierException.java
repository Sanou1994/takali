package com.connecsen.oterrain.exception.createexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreateFichierException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CreateFichierException(String equipe) {
        super(String.format("fichier with name is '%s' not found", equipe));
    }
}
