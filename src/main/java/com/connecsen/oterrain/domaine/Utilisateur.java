package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author akane
 *
 */
@Entity
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	private String prenom;
	private String adresse;
	private String typeId;
	private String numeroId;
	private String naissance;
	private String email;
	private String telephone;
	private String password;
	@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<Terrain> terrains = new ArrayList<Terrain>();
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(Long id, String username, String prenom, String adresse, String typeId, String numeroId,
			String naissance, String email, String telephone, String password, List<Role> roles,
			List<Terrain> terrains, List<Reservation> reservations) {
		super();
		this.id = id;
		this.username = username;
		this.prenom = prenom;
		this.adresse = adresse;
		this.typeId = typeId;
		this.numeroId = numeroId;
		this.naissance = naissance;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.roles = roles;
		this.terrains = terrains;
		this.reservations = reservations;
	}

	public Utilisateur(String username, String prenom, String adresse, String typeId, String numeroId, String naissance,
			String email, String telephone, String password, List<Role> roles, List<Terrain> terrains,
			List<Reservation> reservations) {
		super();
		this.username = username;
		this.prenom = prenom;
		this.adresse = adresse;
		this.typeId = typeId;
		this.numeroId = numeroId;
		this.naissance = naissance;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.roles = roles;
		this.terrains = terrains;
		this.reservations = reservations;
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
   @JsonIgnore
	public String getPassword() {
		return password;
	}
    @JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
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

	

}
