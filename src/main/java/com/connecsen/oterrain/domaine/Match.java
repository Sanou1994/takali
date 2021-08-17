package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity @JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "id")
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String scoreVisiteur;
	private String scoreVisite;
	private String niveauTournoi;
	private String codeVideoEmded;
	private String annule;
	private String repousse;
	@ManyToMany(targetEntity=Equipe.class) 
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Equipe>equipeVisites = new ArrayList<Equipe>();
	@ManyToMany(targetEntity=Equipe.class) 
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Equipe> equipeVisiteurs = new ArrayList<Equipe>();
	@OneToOne (targetEntity=Reservation.class, mappedBy="match")
	private Reservation reservation;
	@ManyToOne 
	private Terrain terrain;
	@ManyToOne 
	private Tournoi tournoi;
	
	public Match(String scoreVisiteur, String scoreVisite, String niveauTournoi, String codeVideoEmded, String annule,
			String repousse, List<Equipe> equipeVisites, List<Equipe> equipeVisiteurs, Reservation reservation,
			 Terrain terrain,  Tournoi tournoi) {
		super();
		this.scoreVisiteur = scoreVisiteur;
		this.scoreVisite = scoreVisite;
		this.niveauTournoi = niveauTournoi;
		this.codeVideoEmded = codeVideoEmded;
		this.annule = annule;
		this.repousse = repousse;
		this.equipeVisites = equipeVisites;
		this.equipeVisiteurs = equipeVisiteurs;
		this.reservation = reservation;
		this.terrain = terrain;
		this.tournoi = tournoi;
	}

	public Match(Long id, String scoreVisiteur, String scoreVisite, String niveauTournoi, String codeVideoEmded,
			String annule, String repousse, List<Equipe> equipeVisites, List<Equipe> equipeVisiteurs,
			Reservation reservation, Terrain terrain, Tournoi tournoi) {
		super();
		this.id = id;
		this.scoreVisiteur = scoreVisiteur;
		this.scoreVisite = scoreVisite;
		this.niveauTournoi = niveauTournoi;
		this.codeVideoEmded = codeVideoEmded;
		this.annule = annule;
		this.repousse = repousse;
		this.equipeVisites = equipeVisites;
		this.equipeVisiteurs = equipeVisiteurs;
		this.reservation = reservation;
		this.terrain = terrain;
		this.tournoi = tournoi;
	}

	public Match() {
		super();
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
	
}
