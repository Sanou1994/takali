package com.connecsen.oterrain.exception.createexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreateMatchException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CreateMatchException(String equipe) {
        super(String.format("match with name is '%s' not found", equipe));
    }
}
