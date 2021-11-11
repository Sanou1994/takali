package com.connecsen.oterrain.domaine.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Transaction;
import com.connecsen.oterrain.domaine.Versement;

public class UserDtoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String prenom;
	private String nom;
	private String adresse;
	private String typeId;
	private String numeroId;
	private boolean userDelete;
	private String naissance;
	private String email;
	private String telephone;
	private String monToken;
	private String compteBancaire;
	private String password;
    private String resetPasswordToken;
	private Role roles ;
	private List<Terrain> terrains = new ArrayList<Terrain>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private List<Versement> versements = new ArrayList<Versement>();

	public UserDtoResponse(Long id, String username, String prenom, String nom, String adresse, String typeId,
			String numeroId, boolean userDelete, String naissance, String email, String telephone, String monToken,
			String compteBancaire,String password, String resetPasswordToken, Role roles, List<Terrain> terrains,
			List<Reservation> reservations,List<Transaction> transactions,
			List<Versement> versements) {
		super();
		this.id = id;
		this.username = username;
		this.prenom = prenom;
		this.nom = nom;
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
		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
		this.terrains = terrains;
		this.reservations = reservations;
		this.transactions = transactions;
		this.versements = versements;

	}


	public UserDtoResponse() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTypeId() {
		return typeId;
	}


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public String getNumeroId() {
		return numeroId;
	}


	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}


	public boolean isUserDelete() {
		return userDelete;
	}


	public void setUserDelete(boolean userDelete) {
		this.userDelete = userDelete;
	}


	public String getNaissance() {
		return naissance;
	}


	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMonToken() {
		return monToken;
	}


	public void setMonToken(String monToken) {
		this.monToken = monToken;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getResetPasswordToken() {
		return resetPasswordToken;
	}


	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}


	public Role getRoles() {
		return roles;
	}


	public void setRoles(Role roles) {
		this.roles = roles;
	}


	public List<Terrain> getTerrains() {
		return terrains;
	}


	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}


	public List<Versement> getVersements() {
		return versements;
	}


	public void setVersements(List<Versement> versements) {
		this.versements = versements;
	}


	public String getCompteBancaire() {
		return compteBancaire;
	}


	public void setCompteBancaire(String compteBancaire) {
		this.compteBancaire = compteBancaire;
	}
	
	
	
}
