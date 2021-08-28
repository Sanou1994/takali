package com.connecsen.oterrain.domaine.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.Match;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class TournoiDtoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private String annee;
	private String description;
	private Double prixPartSrl;
	private Double prixPartSa;
	private Double prixPartEcole;
	private Double prixPme;
	private Date dateDebut;
	private Date dateFin;
	private List<Match> matchs = new ArrayList<Match>();
	private List<Equipe> equipes = new ArrayList<Equipe>();
}
