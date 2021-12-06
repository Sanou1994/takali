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
	private String reference;
	private String email;
	private Long idUser;
	public VersementDtoRequest(Date date, double montant, String status, String typeVersement,String reference,String email,Long idUser) {
		super();
		this.date = date;
		this.montant = montant;
		this.status = status;
		this.typeVersement = typeVersement;
		this.reference = reference;
		this.email = email;
		this.idUser = idUser;
	}
	
}
