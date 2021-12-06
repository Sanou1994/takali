package com.connecsen.oterrain.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SoldeProprietaire {
	private Long idProprietaire;
	private double montantTotalReservations;
	private double montantTotalDemandeVersement;

}
