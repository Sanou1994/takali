package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor

public class Reservation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dateDebut;
	private String heureDebut;
	private String dateFin;
	private String heureFin;
	@OneToOne
	private Match match;
	@OneToOne @Column(nullable = false)
	private Utilisateur user;
	@ManyToOne @Column(nullable = false)
	private Terrain terrain;

}
