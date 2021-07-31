package com.connecsen.oterrain.domaine.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class RoleDtoRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String libelle ;
	private Collection<UserDtoRequest> users = new ArrayList<UserDtoRequest>();
}
