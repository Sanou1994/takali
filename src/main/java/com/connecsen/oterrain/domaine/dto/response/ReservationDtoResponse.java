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
	private String dateDebut;
	private String heureDebut;
	private String dateFin;
	private String heureFin;
	private Match match;
	private Utilisateur user;
	private Terrain terrain;
}
