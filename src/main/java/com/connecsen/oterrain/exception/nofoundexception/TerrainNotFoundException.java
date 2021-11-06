package com.connecsen.oterrain.exception.nofoundexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TerrainNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public TerrainNotFoundException(Long username) {
        super(String.format("terrain with id '%s' not found", username));
    }
}
