package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity  @AllArgsConstructor @NoArgsConstructor 
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date=new Date();
	private String order_number;
	private double montant;
	private String typeTransaction;
	private String status;
	@ManyToOne
	private Terrain terrain;
	@ManyToOne
	private Tournoi tournoi;
	@ManyToOne
	private Utilisateur user;
	public Transaction(Date date, String order_number, double montant, String typeTransaction, String status,
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getTypeTransaction() {
		return typeTransaction;
	}
	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
}
