package com.connecsen.oterrain.domaine.dto.request;

import java.util.Date;

import lombok.Data;
@Data
public class VersementDtoRequest {
	private Long id;
	private Date date ;
	private double montant;
	private String status;
	private String typeVersement;
	public VersementDtoRequest(Date date, double montant, String status, String typeVersement) {
		super();
		this.date = date;
		this.montant = montant;
		this.status = status;
		this.typeVersement = typeVersement;
	}
	
}
