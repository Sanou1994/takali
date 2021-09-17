package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Publicite implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endroit;
	private String dateDebut;
	private String dateFin;
	private String urlPub;
	@OneToOne(targetEntity=Multimedia.class,cascade =CascadeType.PERSIST)
	private Multimedia multimedia;
	
	public Publicite() {
		super();
	}
	
	
	public Publicite(String endroit, String dateDebut, String dateFin, String urlPub, Multimedia multimedia) {
		super();
		this.endroit = endroit;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.urlPub = urlPub;
		this.multimedia = multimedia;
	}

	

	public Publicite(Long id, String endroit, String dateDebut, String dateFin, String urlPub, Multimedia multimedia) {
		super();
		this.id = id;
		this.endroit = endroit;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.urlPub = urlPub;
		this.multimedia = multimedia;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEndroit() {
		return endroit;
	}
	public void setEndroit(String endroit) {
		this.endroit = endroit;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}


	public String getUrlPub() {
		return urlPub;
	}


	public void setUrlPub(String urlPub) {
		this.urlPub = urlPub;
	}
	
}
