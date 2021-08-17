package com.connecsen.oterrain.domaine.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class MatchDtoRequest {

	private Long id;
	private String scoreVisiteur;
	private String scoreVisite;
	private String niveauTournoi;
	private String codeVideoEmded;
	private String annule;
	private String repousse;
	private List<Equipe>equipeVisites = new ArrayList<Equipe>();
	private List<Equipe> equipeVisiteurs = new ArrayList<Equipe>();
	private Reservation reservation;
	private Terrain terrain;
	private Tournoi tournoi;
}
