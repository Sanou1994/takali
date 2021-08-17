package com.connecsen.oterrain.domaine.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FichierDtoResponse {
	private Long id;
	private String typeFichier;
	private String urlFichier;
	private String description;
}
