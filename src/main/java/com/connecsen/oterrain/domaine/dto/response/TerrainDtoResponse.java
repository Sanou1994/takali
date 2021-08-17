package com.connecsen.oterrain.domaine.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class TerrainDtoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private String adresse;
	private String ville;
	private String latitude;
	private String longitude;
	private String disponibilite;
	private String description;
	private Double prixHeure;
	private Double prixDemiHeure;
	private List<Match> matchs = new ArrayList<Match>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private Utilisateur user;
}