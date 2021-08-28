package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.Date;

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
	private Date dateDebut;
	private String heureDebut;
	private Date dateFin;
	private String heureFin;
	@OneToOne 
	private Match match;
	@ManyToOne(targetEntity=Utilisateur.class)
	private Utilisateur user;
	@ManyToOne 
	private Terrain terrain;
	public Reservation(Date dateDebut, String heureDebut, Date dateFin, String heureFin, Match match,
			Utilisateur user, Terrain terrain) {
		super();
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
		this.match = match;
		this.user = user;
		this.terrain = terrain;
	}
	public Reservation(Long id, Date dateDebut, String heureDebut, Date dateFin, String heureFin, Match match,
			Utilisateur user, Terrain terrain) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	

}
