package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity 
public class Fichier implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String typeFichier;
	@OneToOne
	private Multimedia multimedia;
	private String description;
	public Fichier() {
		super();
	}
	public Fichier(String typeFichier, Multimedia multimedia, String description) {
		super();
		this.typeFichier = typeFichier;
		this.multimedia = multimedia;
		this.description = description;
	}
	public Fichier(Long id, String typeFichier, Multimedia multimedia, String description) {
		super();
		this.id = id;
		this.typeFichier = typeFichier;
		this.multimedia = multimedia;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeFichier() {
		return typeFichier;
	}
	public void setTypeFichier(String typeFichier) {
		this.typeFichier = typeFichier;
	}
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
