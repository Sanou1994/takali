package com.connecsen.oterrain.exception.createexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreateHomeOneException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CreateHomeOneException(String equipe) {
        super(String.format("homeOne with name is '%s' not found", equipe));
    }
}
