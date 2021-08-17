package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity @JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "id")
class Multimedia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String file ;
	@OneToOne(targetEntity=HomeOne.class,mappedBy = "multimedia")
	private HomeOne homeone;
	@OneToOne(targetEntity=Fichier.class,mappedBy = "multimedia")
	private Fichier fichier;
	@OneToOne(targetEntity=Propos.class,mappedBy = "multimedia")
	private Propos propos;
	@OneToOne(targetEntity=Service.class,mappedBy = "multimedia")
	private Service service;
	@ManyToOne(targetEntity=Service.class,fetch = FetchType.EAGER) 
	private Terrain terrain ;
	public Multimedia() {
		super();
	}
	public Multimedia(String file, HomeOne homeone, Fichier fichier, Propos propos, Service service, Terrain terrain) {
		super();
		this.file = file;
		this.homeone = homeone;
		this.fichier = fichier;
		this.propos = propos;
		this.service = service;
		this.terrain = terrain;
	}
	public Multimedia(Long id, String file, HomeOne homeone, Fichier fichier, Propos propos, Service service,
			Terrain terrain) {
		super();
		this.id = id;
		this.file = file;
		this.homeone = homeone;
		this.fichier = fichier;
		this.propos = propos;
		this.service = service;
		this.terrain = terrain;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public HomeOne getHomeone() {
		return homeone;
	}
	public void setHomeone(HomeOne homeone) {
		this.homeone = homeone;
	}
	public Fichier getFichier() {
		return fichier;
	}
	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}
	public Propos getPropos() {
		return propos;
	}
	public void setPropos(Propos propos) {
		this.propos = propos;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	

}
