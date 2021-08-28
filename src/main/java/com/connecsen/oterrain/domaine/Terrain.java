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
@Entity 
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
	private Double prixHeure;
	private Double prixDemiHeure;
	
	@OneToMany(targetEntity=Multimedia.class,cascade = CascadeType.ALL,mappedBy="terrain")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Multimedia> multimedia = new ArrayList<Multimedia>();
	@OneToMany(targetEntity=Match.class, mappedBy="terrain",cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Match> matchs = new ArrayList<Match>();
	@OneToMany(targetEntity=Reservation.class, mappedBy="terrain",cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Reservation> reservations = new ArrayList<Reservation>();
	@ManyToOne 
	private Utilisateur user;
	public Terrain(String nom, String adresse, String ville, String latitude, String longitude, String disponibilite,
			String description, Double prixHeure, Double prixDemiHeure, List<Multimedia> multimedia, List<Match> matchs,
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
			String disponibilite, String description, Double prixHeure, Double prixDemiHeure,
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrixHeure() {
		return prixHeure;
	}
	public void setPrixHeure(Double prixHeure) {
		this.prixHeure = prixHeure;
	}
	public Double getPrixDemiHeure() {
		return prixDemiHeure;
	}
	public void setPrixDemiHeure(Double prixDemiHeure) {
		this.prixDemiHeure = prixDemiHeure;
	}
	public List<Multimedia> getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(List<Multimedia> multimedia) {
		this.multimedia = multimedia;
	}
	
	
	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	
}
