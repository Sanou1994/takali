package com.connecsen.oterrain.domaine.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.Match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class TournoiDtoRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private String annee;
	private String description;
	private Double prixPartSrl;
	private Double prixPartSa;
	private Double prixPartEcole;
	private Double prixPme;
	private String dateDebut;
	private String dateFin;
	private Collection<Match> matchs = new ArrayList<Match>();
	private Collection<Equipe> equipes = new ArrayList<Equipe>();
}
