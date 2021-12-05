package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity  @AllArgsConstructor @NoArgsConstructor
public class UserDoReservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idUser;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	@OneToOne(targetEntity=Reservation.class, mappedBy="userDoReservation")
	private Reservation reservation;
	public UserDoReservation(long idUser, String nom, String prenom, String adresse,String telephone,Reservation reservation) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.reservation = reservation;
	}
	
	public UserDoReservation() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	

}
