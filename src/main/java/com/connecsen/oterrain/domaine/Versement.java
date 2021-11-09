package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity  @AllArgsConstructor @NoArgsConstructor @Data
public class Versement implements Serializable{
private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date date ;
private double montant;
private String status;
private String typeVersement;
@ManyToOne
private Utilisateur user;
public Versement(Date date, double montant, String status, String typeVersement, Utilisateur user) {
	super();
	this.date = date;
	this.montant = montant;
	this.status = status;
	this.typeVersement = typeVersement;
	this.user = user;
}


}
