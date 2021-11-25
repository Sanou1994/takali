package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ListeHeureReserver implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private long idReservation ;
	private long numeroJour;
	private long numeroMois;
	private String heure;
	@ManyToOne(targetEntity = Terrain.class)
	private Terrain terrain;
	public ListeHeureReserver(long idReservation,long numeroJour, long numeroMois, String heure,  Terrain terrain) {
		super();
		this.idReservation = idReservation;
		this.numeroJour = numeroJour;
		this.numeroMois = numeroMois;
		this.heure = heure;
		this.terrain = terrain;
	}
	public ListeHeureReserver(long id,long idReservation,long numeroJour, long numeroMois, String heure,  Terrain terrain) {
		super();
		this.id = id;
		this.idReservation = idReservation;
		this.numeroJour = numeroJour;
		this.numeroMois = numeroMois;
		this.heure = heure;
		this.terrain = terrain;
	}
	public ListeHeureReserver() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumeroJour() {
		return numeroJour;
	}
	public void setNumeroJour(long numeroJour) {
		this.numeroJour = numeroJour;
	}
	public long getNumeroMois() {
		return numeroMois;
	}
	public void setNumeroMois(long numeroMois) {
		this.numeroMois = numeroMois;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	public void setTerrain( Terrain terrain) {
		this.terrain = terrain;
	}
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	

}
