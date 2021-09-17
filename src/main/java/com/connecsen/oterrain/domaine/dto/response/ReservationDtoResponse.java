package com.connecsen.oterrain.domaine.dto.response;

import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class ReservationDtoResponse {
	private Long id;
	private String statePayement;
	private String dateReservation;
	private String heure;
	private Match match;
	private Utilisateur user;
	private Terrain terrain;
}
