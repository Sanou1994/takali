package com.connecsen.oterrain.exception.createexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreateException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CreateException() {
        super(String.format("objet don't create or no update"));
    }
}
