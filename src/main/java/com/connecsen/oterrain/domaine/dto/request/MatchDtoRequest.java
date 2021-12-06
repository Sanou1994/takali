package com.connecsen.oterrain.domaine.dto.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data  @AllArgsConstructor @NoArgsConstructor
public class MatchDtoRequest {

	private Long id;
	private String scoreVisiteur;
	private String scoreVisite;
	private String niveauTournoi;
	private String codeVideoEmded;
	private String annule;
	private boolean status=true;
	private boolean matchDejaJoue = false;
	private String repousse;
	private String nomTournoi;
	private Date dateDebutTournoi;
	private Date dateFinTournoi;
	private List<Equipe>equipeVisites = new ArrayList<Equipe>();
	private List<Equipe> equipeVisiteurs = new ArrayList<Equipe>();
	private Reservation reservation;
	private Terrain terrain;
	private List<Tournoi>tournois= new ArrayList<Tournoi>();
	private long idTournoi;
	private String date;
	private String heure;
	
	
}
