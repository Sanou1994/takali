package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
@Entity @Data @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Reservation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dateDebut;
	private String heureDebut;
	private String dateFin;
	private String heureFin;
	@OneToOne 
	private Match match;
	@ManyToOne(targetEntity=Utilisateur.class)
	private Utilisateur user;
	@ManyToOne 
	private Terrain terrain;
	public Reservation(String dateDebut, String heureDebut, String dateFin, String heureFin, Match match,
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
	public Reservation(Long id, String dateDebut, String heureDebut, String dateFin, String heureFin, Match match,
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
	

}
