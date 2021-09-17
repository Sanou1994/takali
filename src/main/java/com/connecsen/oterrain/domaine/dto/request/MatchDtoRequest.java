package com.connecsen.oterrain.domaine.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;

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
	private List<Equipe>equipeVisites = new ArrayList<Equipe>();
	private List<Equipe> equipeVisiteurs = new ArrayList<Equipe>();
	private Reservation reservation;
	private Terrain terrain;
	private Tournoi tournoi;
	public MatchDtoRequest() {
		super();
	}
	public MatchDtoRequest(String scoreVisiteur, String scoreVisite, String niveauTournoi, String codeVideoEmded,
			String annule,boolean matchDejaJoue,  boolean status,String repousse, List<Equipe> equipeVisites, List<Equipe> equipeVisiteurs,
			Reservation reservation, Terrain terrain, Tournoi tournoi) {
		super();
		this.scoreVisiteur = scoreVisiteur;
		this.scoreVisite = scoreVisite;
		this.niveauTournoi = niveauTournoi;
		this.codeVideoEmded = codeVideoEmded;
		this.annule = annule;
		this.status = status;
		this.matchDejaJoue = matchDejaJoue;
		this.repousse = repousse;
		this.equipeVisites = equipeVisites;
		this.equipeVisiteurs = equipeVisiteurs;
		this.reservation = reservation;
		this.terrain = terrain;
		this.tournoi = tournoi;
	}
	public MatchDtoRequest(Long id, String scoreVisiteur, String scoreVisite, String niveauTournoi,
			String codeVideoEmded, String annule,boolean matchDejaJoue, boolean status, String repousse, List<Equipe> equipeVisites,
			List<Equipe> equipeVisiteurs, Reservation reservation, Terrain terrain, Tournoi tournoi) {
		super();
		this.id = id;
		this.scoreVisiteur = scoreVisiteur;
		this.scoreVisite = scoreVisite;
		this.niveauTournoi = niveauTournoi;
		this.codeVideoEmded = codeVideoEmded;
		this.annule = annule;
		this.status = status;
		this.matchDejaJoue = matchDejaJoue;
		this.repousse = repousse;
		this.equipeVisites = equipeVisites;
		this.equipeVisiteurs = equipeVisiteurs;
		this.reservation = reservation;
		this.terrain = terrain;
		this.tournoi = tournoi;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getScoreVisiteur() {
		return scoreVisiteur;
	}
	public void setScoreVisiteur(String scoreVisiteur) {
		this.scoreVisiteur = scoreVisiteur;
	}
	public String getScoreVisite() {
		return scoreVisite;
	}
	public void setScoreVisite(String scoreVisite) {
		this.scoreVisite = scoreVisite;
	}
	public String getNiveauTournoi() {
		return niveauTournoi;
	}
	public void setNiveauTournoi(String niveauTournoi) {
		this.niveauTournoi = niveauTournoi;
	}
	public String getCodeVideoEmded() {
		return codeVideoEmded;
	}
	public void setCodeVideoEmded(String codeVideoEmded) {
		this.codeVideoEmded = codeVideoEmded;
	}
	public String getAnnule() {
		return annule;
	}
	public void setAnnule(String annule) {
		this.annule = annule;
	}
	public String getRepousse() {
		return repousse;
	}
	public void setRepousse(String repousse) {
		this.repousse = repousse;
	}
	
	public boolean isMatchDejaJoue() {
		return matchDejaJoue;
	}
	public void setMatchDejaJoue(boolean matchDejaJoue) {
		this.matchDejaJoue = matchDejaJoue;
	}
	public List<Equipe> getEquipeVisites() {
		return equipeVisites;
	}
	public void setEquipeVisites(List<Equipe> equipeVisites) {
		this.equipeVisites = equipeVisites;
	}
	public List<Equipe> getEquipeVisiteurs() {
		return equipeVisiteurs;
	}
	public void setEquipeVisiteurs(List<Equipe> equipeVisiteurs) {
		this.equipeVisiteurs = equipeVisiteurs;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public Tournoi getTournoi() {
		return tournoi;
	}
	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
