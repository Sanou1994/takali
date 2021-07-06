package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author akane
 *
 */
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String typeId;
	private String numeroId;
	private String naissance;
	private String email;
	private String telephone;
	private String password;
	@ManyToOne @Column(nullable = false)
	private Role role;
	@OneToMany(mappedBy = "user")
	private List<Terrain> terrains = new ArrayList<Terrain>();
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations = new ArrayList<Reservation>();

	

}
