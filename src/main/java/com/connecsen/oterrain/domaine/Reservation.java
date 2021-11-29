package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity 
public class Reservation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idTerrain;
	private String nomTerrain;
	private double montant;
	private double montantTotal;
	private String statePayement;
	private String dateReservation;
	private String heure;
	private Date dateReservationTypeDate;
	@OneToOne 
	private Match match;
	@ManyToOne(targetEntity=Utilisateur.class)
	private Utilisateur user;
	@ManyToOne 
	private Terrain terrain;
	@OneToOne(targetEntity=UserDoReservation.class,cascade = CascadeType.ALL)
	private UserDoReservation userDoReservation;
	
	public Reservation(Long idUserDoReservation,Long idTerrain, String nomTerrain, double montant, double montantTotal, String statePayement,
			String dateReservation, String heure,Date dateReservationTypeDate, Match match, Utilisateur user, Terrain terrain, UserDoReservation userDoReservation) {
		super();
		this.idTerrain = idTerrain;
		this.nomTerrain = nomTerrain;
		this.montant = montant;
		this.montantTotal = montantTotal;
		this.statePayement = statePayement;
		this.dateReservation = dateReservation;
		this.heure = heure;
		this.dateReservationTypeDate = dateReservationTypeDate;
		this.match = match;
		this.user = user;
		this.terrain = terrain;
		this.userDoReservation = userDoReservation;
	}
	
	public Reservation(Long id,Long idUserDoReservation, Long idTerrain, String nomTerrain, double montant, double montantTotal,
			String statePayement, String dateReservation, String heure,Date dateReservationTypeDate, Match match, Utilisateur user,
			Terrain terrain, UserDoReservation userDoReservation) {
		super();
		this.id = id;
		this.idTerrain = idTerrain;
		this.nomTerrain = nomTerrain;
		this.montant = montant;
		this.montantTotal = montantTotal;
		this.statePayement = statePayement;
		this.dateReservation = dateReservation;
		this.heure = heure;
		this.dateReservationTypeDate = dateReservationTypeDate;
		this.match = match;
		this.user = user;
		this.terrain = terrain;
		this.userDoReservation = userDoReservation;

	}

	public Long getIdTerrain() {
		return idTerrain;
	}

	public void setIdTerrain(Long idTerrain) {
		this.idTerrain = idTerrain;
	}

	public String getNomTerrain() {
		return nomTerrain;
	}

	public void setNomTerrain(String nomTerrain) {
		this.nomTerrain = nomTerrain;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public Reservation() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatePayement() {
		return statePayement;
	}
	public void setStatePayement(String statePayement) {
		this.statePayement = statePayement;
	}
	public String getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public UserDoReservation getUserDoReservation() {
		return this.userDoReservation;
	}

	public void setUserDoReservation(UserDoReservation userDoReservation) {
		this.userDoReservation = userDoReservation;
	}

	public Date getDateReservationTypeDate() {
		return dateReservationTypeDate;
	}

	public void setDateReservationTypeDate(Date dateReservationTypeDate) {
		this.dateReservationTypeDate = dateReservationTypeDate;
	}
	

}
