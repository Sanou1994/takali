package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity  @AllArgsConstructor @NoArgsConstructor
public class Prix implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String typeDePrix;
	private double valeur;
	private String jour;
	@ManyToOne
	private Terrain terrain;
	
	
	public Prix(String typeDePrix, double valeur, String jour, Terrain terrain) {
		super();
		this.typeDePrix = typeDePrix;
		this.valeur = valeur;
		this.jour = jour;
		this.terrain = terrain;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeDePrix() {
		return typeDePrix;
	}
	public void setTypeDePrix(String typeDePrix) {
		this.typeDePrix = typeDePrix;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	
}
