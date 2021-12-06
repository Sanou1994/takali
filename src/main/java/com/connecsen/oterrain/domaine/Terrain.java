package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity 
public class Terrain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private String ville;
	private String latitude;
	private String longitude;
	private String disponibilite;
	@Lob
	private String description;
	private String statusTerrain ;
	private Long idUser;
	private Date dateInscription;
	@OneToOne(targetEntity=Indisponibilite.class,cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
	private  Indisponibilite indisponibilite ;
	@OneToMany(targetEntity=ListeHeureReserver.class,mappedBy="terrain",cascade =CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ListeHeureReserver> listeHeureReserver = new ArrayList<ListeHeureReserver>();
	@ManyToMany(targetEntity=Multimedia.class,cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Multimedia> multimedias = new ArrayList<Multimedia>();
	@OneToMany(targetEntity=Match.class, mappedBy="terrain",cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Match> matchs = new ArrayList<Match>();
	@OneToMany(targetEntity=Reservation.class, mappedBy="terrain",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Reservation> reservations = new ArrayList<Reservation>();
	@OneToMany(targetEntity=Transaction.class, mappedBy="terrain",cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	@ManyToOne 
	private Utilisateur user;
	@OneToMany(targetEntity=Prix.class, mappedBy="terrain",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Prix> prix = new ArrayList<Prix>();
	public Terrain(String nom, String adresse, String ville, String latitude, String longitude, String disponibilite,
			String description,String statusTerrain,Long idUser,Date dateInscription,Indisponibilite indisponibilite,List<ListeHeureReserver> listeHeureReserver, List<Multimedia> multimedia, List<Match> matchs,
			List<Reservation> reservations,List<Transaction> transactions, Utilisateur user, List<Prix> prix) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.latitude = latitude;
		this.longitude = longitude;
		this.disponibilite = disponibilite; 
		this.description = description;
		this.statusTerrain = statusTerrain;
		this.idUser = idUser;
		this.dateInscription = dateInscription;
		this.indisponibilite = indisponibilite;
		this.listeHeureReserver = listeHeureReserver;
		this.multimedias = multimedia;
		this.matchs = matchs;
		this.reservations = reservations;
		this.transactions = transactions;
		this.user = user;  
		this.prix = prix;

	}
	public Terrain(Long id, String nom, String adresse, String ville, String latitude, String longitude,
			String disponibilite, String description, String statusTerrain,Long idUser,Date dateInscription,Indisponibilite indisponibilite,List<ListeHeureReserver> listeHeureReserver,
			List<Multimedia> multimedia, List<Match> matchs, List<Reservation> reservations,List<Transaction> transactions, Utilisateur user,List<Prix> prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.latitude = latitude;
		this.longitude = longitude;
		this.disponibilite = disponibilite;
		this.description = description;
		this.statusTerrain = statusTerrain;
		this.idUser = idUser;
		this.dateInscription = dateInscription;
		this.indisponibilite = indisponibilite;
		this.multimedias = multimedia;
		this.listeHeureReserver = listeHeureReserver;
		this.matchs = matchs;
		this.reservations = reservations;
		this.transactions = transactions;
		this.user = user;
		this.prix = prix;
	}
	
	public Terrain() {
		super();
	}
	
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatusTerrain() {
		return statusTerrain;
	}
	public void setStatusTerrain(String statusTerrain) {
		this.statusTerrain = statusTerrain;
	}
	
	public Indisponibilite getIndisponibilite() {
		return indisponibilite;
	}
	public void setIndisponibilite(Indisponibilite indisponibilite) {
		this.indisponibilite = indisponibilite;
	}
	public List<Multimedia> getMultimedias() {
		return multimedias;
	}
	public void setMultimedias(List<Multimedia> multimedia) {
		this.multimedias = multimedia;
	}
	
	
	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public List<ListeHeureReserver> getListeHeureReserver() {
		return listeHeureReserver;
	}
	public void setListeHeureReserver(List<ListeHeureReserver> listeHeureReserver) {
		this.listeHeureReserver = listeHeureReserver;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public List<Prix> getPrix() {
		return prix;
	}
	public void setPrix(List<Prix> prix) {
		this.prix = prix;
	}
	
	
}
