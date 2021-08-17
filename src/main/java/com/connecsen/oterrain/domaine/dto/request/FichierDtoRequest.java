package com.connecsen.oterrain.domaine.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FichierDtoRequest {
	private Long id;
	private String typeFichier;
	private String urlFichier;
	private String description;
}
