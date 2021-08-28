package com.connecsen.oterrain.domaine.dto.response;

import java.util.Date;

import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class ReservationDtoResponse {
	private Long id;
	private Date dateDebut;
	private String heureDebut;
	private Date dateFin;
	private String heureFin;
	private Match match;
	private Utilisateur user;
	private Terrain terrain;
}
