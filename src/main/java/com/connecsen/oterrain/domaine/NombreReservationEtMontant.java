package com.connecsen.oterrain.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class NombreReservationEtMontant {
	private int nombreReservation;
	private double montantTotal;

}
