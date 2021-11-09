package com.connecsen.oterrain.domaine.dto.request;

import java.util.Date;
import com.connecsen.oterrain.domaine.Utilisateur;

import lombok.Data;
@Data
public class VersementDtoRequest {
	private Long id;
	private Date date ;
	private double montant;
	private String status;
	private String typeVersement;
	private Utilisateur user;
	public VersementDtoRequest(Date date, double montant, String status, String typeVersement, Utilisateur user) {
		super();
		this.date = date;
		this.montant = montant;
		this.status = status;
		this.typeVersement = typeVersement;
		this.user = user;
	}
	
}
