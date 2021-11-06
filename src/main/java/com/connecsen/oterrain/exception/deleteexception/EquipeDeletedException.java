package com.connecsen.oterrain.exception.deleteexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EquipeDeletedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EquipeDeletedException(Long id) {
        super(String.format("equipe with id '%s' can't deleted", id));
    }
}
