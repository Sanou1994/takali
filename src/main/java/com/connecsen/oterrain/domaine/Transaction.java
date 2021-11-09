package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity  @AllArgsConstructor @NoArgsConstructor @Data
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private long order_number;
	private double montant;
	private String typeTransaction;
	private boolean status;
	@ManyToOne
	private Terrain terrain;
	@ManyToOne
	private Tournoi tournoi;
	@ManyToOne
	private Utilisateur user;
	public Transaction(Date date, long order_number, double montant, String typeTransaction, boolean status,
			Terrain terrain, Tournoi tournoi, Utilisateur user) {
		super();
		this.date = date;
		this.order_number = order_number;
		this.montant = montant;
		this.typeTransaction = typeTransaction;
		this.status = status;
		this.terrain = terrain;
		this.tournoi = tournoi;
		this.user = user;
	}
	
}
