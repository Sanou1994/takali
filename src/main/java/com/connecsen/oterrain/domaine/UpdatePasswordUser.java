package com.connecsen.oterrain.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UpdatePasswordUser {
    private Long idUser;
	private String oldPassword;
	private String newPassword;
}
