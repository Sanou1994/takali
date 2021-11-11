package com.connecsen.oterrain.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
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
	@ElementCollection(targetClass=Integer.class)
	private List<Integer>days=new ArrayList<Integer>();
	@ElementCollection(targetClass=String.class)
	private List<String> heures=new ArrayList<String>();
	@ElementCollection(targetClass=String.class)
	private List<String> heurePrecises=new ArrayList<String>();
	private String datePrecise;
    @OneToOne(targetEntity=Terrain.class, mappedBy="indisponibilite")
    private Terrain terrain;
	public Indisponibilite( List<Integer> days, List<String> heures,
			List<String> heurePrecises, String datePrecise, Terrain terrain) {
		super();
		this.days = days;
		this.heures = heures;
		this.heurePrecises = heurePrecises;
		this.datePrecise = datePrecise;
		this.terrain = terrain;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Integer> getDays() {
		return days;
	}
	public void setDays(List<Integer> days) {
		this.days = days;
	}
	public List<String> getHeures() {
		return heures;
	}
	public void setHeures(List<String> heures) {
		this.heures = heures;
	}
	public List<String> getHeurePrecises() {
		return heurePrecises;
	}
	public void setHeurePrecises(List<String> heurePrecises) {
		this.heurePrecises = heurePrecises;
	}
	public String getDatePrecise() {
		return datePrecise;
	}
	public void setDatePrecise(String datePrecise) {
		this.datePrecise = datePrecise;
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
    
   
	
	
    
}
