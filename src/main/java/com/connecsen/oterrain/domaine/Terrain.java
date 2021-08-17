package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
@Entity @JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "id") @Data
public class Terrain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private String ville;
	private String latitude;
	private String longitude;
	private String disponibilite;
	private String description;
	private double prixHeure;
	private double prixDemiHeure;
	
	@OneToMany(targetEntity=Multimedia.class,cascade = CascadeType.ALL,mappedBy="terrain")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Multimedia> multimedia = new ArrayList<Multimedia>();
	@OneToMany(targetEntity=Match.class, mappedBy="terrain")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Match> matchs = new ArrayList<Match>();
	@OneToMany(targetEntity=Reservation.class, mappedBy="terrain")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Reservation> reservations = new ArrayList<Reservation>();
	@ManyToOne 
	private Utilisateur user;
	public Terrain(String nom, String adresse, String ville, String latitude, String longitude, String disponibilite,
			String description, double prixHeure, double prixDemiHeure, List<Multimedia> multimedia, List<Match> matchs,
			List<Reservation> reservations, Utilisateur user) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.latitude = latitude;
		this.longitude = longitude;
		this.disponibilite = disponibilite;
		this.description = description;
		this.prixHeure = prixHeure;
		this.prixDemiHeure = prixDemiHeure;
		this.multimedia = multimedia;
		this.matchs = matchs;
		this.reservations = reservations;
		this.user = user;
	}
	public Terrain(Long id, String nom, String adresse, String ville, String latitude, String longitude,
			String disponibilite, String description, double prixHeure, double prixDemiHeure,
			List<Multimedia> multimedia, List<Match> matchs, List<Reservation> reservations, Utilisateur user) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.latitude = latitude;
		this.longitude = longitude;
		this.disponibilite = disponibilite;
		this.description = description;
		this.prixHeure = prixHeure;
		this.prixDemiHeure = prixDemiHeure;
		this.multimedia = multimedia;
		this.matchs = matchs;
		this.reservations = reservations;
		this.user = user;
	}
	public Terrain() {
		super();
	}
	
	
}
