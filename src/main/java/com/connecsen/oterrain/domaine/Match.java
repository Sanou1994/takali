package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String scoreVisiteur;
	private String scoreVisite;
	private String niveauTournoi;
	private String codeVideoEmded;
	private String annule;
	private String repousse;
	@ManyToMany(mappedBy = "matchVisites")
	private List<Equipe>equipeVisites = new ArrayList<Equipe>();
	@ManyToMany(mappedBy = "matchVisiteurs")
	private List<Equipe> equipeVisiteurs = new ArrayList<Equipe>();
	@OneToOne @NotNull
	private Reservation reservation;
	@ManyToOne @NotNull
	private Terrain terrain;
	@ManyToOne @NotNull
	private Tournoi tournoi;
}
