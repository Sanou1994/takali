package com.connecsen.oterrain.domaine.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PrixDtoRequest {
	private long id;
	private String typeDePrix;
	private double valeur;
	private String jour;
	
	public PrixDtoRequest(String typeDePrix, double valeur, String jour) {
		super();
		this.typeDePrix = typeDePrix;
		this.valeur = valeur;
		this.jour = jour;
		
	}
	
}
