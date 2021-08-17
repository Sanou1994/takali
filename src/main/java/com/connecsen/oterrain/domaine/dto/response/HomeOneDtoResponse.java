package com.connecsen.oterrain.domaine.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class HomeOneDtoResponse {
	private Long id;
	private String titre;
	private String description;
	private String urlImage;
	private String bouton;
	private String telephone;
	private String email;
	private String adresse;
}
