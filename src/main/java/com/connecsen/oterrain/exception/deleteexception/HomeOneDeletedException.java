package com.connecsen.oterrain.exception.deleteexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class HomeOneDeletedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public HomeOneDeletedException(Long id) {
        super(String.format("homeOne with id '%s' can't deleted", id));
    }
}
