package com.connecsen.oterrain.domaine.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.Tournoi;
public class EquipeDtoResponse {
	private Long id;
	private String nomEquipe;
	private String nomEntreprise;
	private String typeEntreprise;
	private Boolean paye;
	private Boolean archive;
	private List<Match>matchVisites = new ArrayList<Match>();
	private List<Match> matchVisiteurs = new ArrayList<Match>();
	private List<Tournoi>tournois = new ArrayList<Tournoi>();
	public EquipeDtoResponse() {
		super();
	}
	public EquipeDtoResponse(Long id, String nomEquipe, String nomEntreprise, String typeEntreprise, Boolean paye,
			Boolean archive, List<Match> matchVisites, List<Match> matchVisiteurs, List<Tournoi> tournois) {
		super();
		this.id = id;
		this.nomEquipe = nomEquipe;
		this.nomEntreprise = nomEntreprise;
		this.typeEntreprise = typeEntreprise;
		this.paye = paye;
		this.archive = archive;
		this.matchVisites = matchVisites;
		this.matchVisiteurs = matchVisiteurs;
		this.tournois = tournois;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getTypeEntreprise() {
		return typeEntreprise;
	}
	public void setTypeEntreprise(String typeEntreprise) {
		this.typeEntreprise = typeEntreprise;
	}
	public Boolean getPaye() {
		return paye;
	}
	public void setPaye(Boolean paye) {
		this.paye = paye;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public List<Match> getMatchVisites() {
		return matchVisites;
	}
	public void setMatchVisites(List<Match> matchVisites) {
		this.matchVisites = matchVisites;
	}
	public List<Match> getMatchVisiteurs() {
		return matchVisiteurs;
	}
	public void setMatchVisiteurs(List<Match> matchVisiteurs) {
		this.matchVisiteurs = matchVisiteurs;
	}
	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}
	public List<Tournoi> getTournois() {
		return tournois;
	}
}
