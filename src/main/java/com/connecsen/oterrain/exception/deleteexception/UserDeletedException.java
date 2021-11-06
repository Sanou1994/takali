package com.connecsen.oterrain.exception.deleteexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserDeletedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserDeletedException(Long id) {
        super(String.format("user with id '%s' can't deleted", id));
    }
}
