package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
@Entity 
public class Fichier implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	private Multimedia multimedia;
	@Lob
	private String description;
	private String typeFichier;
	
	public Fichier() {
		super();
	}
	public Fichier(Multimedia multimedia, String description, String typeFichier) {
		super();
		this.multimedia = multimedia;
		this.description = description;
		this.typeFichier = typeFichier;
	}
	public Fichier(Long id, Multimedia multimedia, String description, String typeFichier) {
		super();
		this.id = id;
		this.multimedia = multimedia;
		this.description = description;
		this.typeFichier = typeFichier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Multimedia  getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia ) {
		this.multimedia = multimedia;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeFichier() {
		return typeFichier;
	}
	public void setTypeFichier(String typeFichier) {
		this.typeFichier = typeFichier;
	}
}
