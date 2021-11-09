package com.connecsen.oterrain.domaine.dto.response;

import java.util.Date;

import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;
import com.connecsen.oterrain.domaine.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionDtoResponse {
	private Long id;
	private Date date;
	private long order_number;
	private double montant;
	private String typeTransaction;
	private boolean status;
	private Terrain terrain;
	private Tournoi tournoi;
	private Utilisateur user;
}
