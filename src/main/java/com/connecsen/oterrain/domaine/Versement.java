package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity  @AllArgsConstructor @NoArgsConstructor 
public class Versement implements Serializable{
private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date date =new Date();
private double montant;
private String status;
private String typeVersement;
private String reference;
private String email;
private Long idUser;

@ManyToOne
private Utilisateur user;
public Versement(Date date, double montant, String status,String reference,String email,Long idUser, String typeVersement, Utilisateur user) {
	super();
	this.date = date;
	this.montant = montant;
	this.status = status;
	this.typeVersement = typeVersement;
	this.reference = reference;
	this.email = email;
	this.idUser = idUser;
	this.user = user;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getTypeVersement() {
	return typeVersement;
}
public void setTypeVersement(String typeVersement) {
	this.typeVersement = typeVersement;
}

public void setUser(Utilisateur user) {
	this.user = user;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getIdUser() {
	return idUser;
}
public void setIdUser(Long idUser) {
	this.idUser = idUser;
}


}
