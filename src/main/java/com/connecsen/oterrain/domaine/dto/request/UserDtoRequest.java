package com.connecsen.oterrain.domaine.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Transaction;
import com.connecsen.oterrain.domaine.Versement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class UserDtoRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String prenom;
	private String adresse;
	private String typeId;
	private String numeroId;
	private String nom;
	private boolean userDelete =false;
	private String naissance;
	private String email;
	private String telephone;
	private String monToken;
	private String password;
	private String compteBancaire;
	private Date dateInscription;
    private String resetPasswordToken;
	private Role roles ;
	private List<Terrain> terrains = new ArrayList<Terrain>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private List<Versement> versements = new ArrayList<Versement>();
	public UserDtoRequest(String username,String nom, String prenom, String adresse, String typeId, String numeroId,
			boolean userDelete,String naissance, String email, String telephone, String monToken, String password,String compteBancaire,
			Date dateInscription,String resetPasswordToken, Role roles, List<Terrain> terrains, List<Reservation> reservations,List<Transaction> transactions,
			List<Versement> versements) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.typeId = typeId;
		this.numeroId = numeroId;
		this.userDelete = userDelete;
		this.naissance = naissance;
		this.email = email;
		this.telephone = telephone;
		this.monToken = monToken;
		this.password = password;
		this.compteBancaire = compteBancaire;
		this.dateInscription = dateInscription;
		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
		this.terrains = terrains;
		this.reservations = reservations;
		this.transactions = transactions;
		this.versements = versements;
	}
	
}
