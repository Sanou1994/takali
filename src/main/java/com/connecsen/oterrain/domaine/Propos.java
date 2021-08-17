package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity 
public class Propos implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	@OneToOne
	private Multimedia multimedia;
	private String text;
	public Propos() {
		super();
	}
	public Propos(String titre, Multimedia multimedia, String text) {
		super();
		this.titre = titre;
		this.multimedia = multimedia;
		this.text = text;
	}
	public Propos(Long id, String titre, Multimedia multimedia, String text) {
		super();
		this.id = id;
		this.titre = titre;
		this.multimedia = multimedia;
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
