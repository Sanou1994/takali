package com.connecsen.oterrain.domaine;

import java.io.Serializable;

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
	private String statePayement;
	private String dateReservation;
	private String heure;
	@OneToOne 
	private Match match;
	@ManyToOne(targetEntity=Utilisateur.class)
	private Utilisateur user;
	@ManyToOne 
	private Terrain terrain;
	public Reservation(String statePayement,String dateReservation, String heure, Match match,
			Utilisateur user, Terrain terrain) {
		super();
		this.statePayement = statePayement;
		this.dateReservation = dateReservation;
		this.heure = heure;
		this.match = match;
		this.user = user;
		this.terrain = terrain;
	}
	public Reservation(Long id,String statePayement, String dateReservation,  String heure, Match match,
			Utilisateur user, Terrain terrain) {
		super();
		this.id = id;
		this.statePayement = statePayement;
		this.dateReservation = dateReservation;
		this.heure = heure;
		this.match = match;
		this.user = user;
		this.terrain = terrain;
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
	

}
