package com.connecsen.oterrain.domaine.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.connecsen.oterrain.domaine.Indisponibilite;
import com.connecsen.oterrain.domaine.ListeHeureReserver;
import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.Multimedia;
import com.connecsen.oterrain.domaine.Prix;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Transaction;

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
	private String description;
	private List<Multimedia> multimedias;
	private String statusTerrain;
	private Long idUser;
	private Date dateInscription;
	private  Indisponibilite indisponibilite ;
	private List<ListeHeureReserver> listeHeureReserver = new ArrayList<ListeHeureReserver>();
	private List<Match> matchs = new ArrayList<Match>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private List<Prix> prix = new ArrayList<Prix>();
		
}