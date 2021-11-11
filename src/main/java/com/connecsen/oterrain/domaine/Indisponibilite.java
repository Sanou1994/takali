package com.connecsen.oterrain.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity  @AllArgsConstructor @NoArgsConstructor
public class Indisponibilite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String day;
	private String heure;
    @OneToOne(targetEntity=Terrain.class, mappedBy="indisponibilite")
    private Terrain terrain;
	public Indisponibilite(String day, String heure, Terrain terrain) {
		super();
		this.day = day;
		this.heure = heure;
		this.terrain = terrain;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
    
}
