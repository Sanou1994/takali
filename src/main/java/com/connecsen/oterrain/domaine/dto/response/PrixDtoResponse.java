package com.connecsen.oterrain.domaine.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class PrixDtoResponse {
	private long id;
	private String typeDePrix;
	private double valeur;
	private String jour;
}
