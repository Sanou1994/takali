package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
public class Equipe implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomEquipe;
	private String nomEntreprise;
	private String typeEntreprise;
	private Boolean paye;
	private Boolean archive;
	@ManyToMany(targetEntity=Match.class, mappedBy="equipeVisites",cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Match>matchVisites = new ArrayList<Match>();
	@ManyToMany(targetEntity=Match.class, mappedBy="equipeVisiteurs",cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private  List<Match> matchVisiteurs = new ArrayList<Match>();
	@ManyToMany(targetEntity=Tournoi.class,cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private  List<Tournoi>tournois = new ArrayList<Tournoi>();
	public Equipe(String nomEquipe, String nomEntreprise, String typeEntreprise, Boolean paye, Boolean archive,
			List<Match> matchVisites, List<Match> matchVisiteurs, List<Tournoi> tournois) {
		super();
		this.nomEquipe = nomEquipe;
		this.nomEntreprise = nomEntreprise;
		this.typeEntreprise = typeEntreprise;
		this.paye = paye;
		this.archive = archive;
		this.matchVisites = matchVisites;
		this.matchVisiteurs = matchVisiteurs;
		this.tournois = tournois;
	}
	public Equipe(Long id, String nomEquipe, String nomEntreprise, String typeEntreprise, Boolean paye, Boolean archive,
			List<Match> matchVisites, List<Match> matchVisiteurs, List<Tournoi> tournois) {
		super();
		this.id = id;
		this.nomEquipe = nomEquipe;
		this.nomEntreprise = nomEntreprise;
		this.typeEntreprise = typeEntreprise;
		this.paye = paye;
		this.archive = archive;
		this.matchVisites = matchVisites;
		this.matchVisiteurs = matchVisiteurs;
		this.tournois = tournois;
	}
	public Equipe() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getTypeEntreprise() {
		return typeEntreprise;
	}
	public void setTypeEntreprise(String typeEntreprise) {
		this.typeEntreprise = typeEntreprise;
	}
	public Boolean getPaye() {
		return paye;
	}
	public void setPaye(Boolean paye) {
		this.paye = paye;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	
	
	public void setMatchVisites(List<Match> matchVisites) {
		this.matchVisites = matchVisites;
	}
	
	public void setMatchVisiteurs(List<Match> matchVisiteurs) {
		this.matchVisiteurs = matchVisiteurs;
	}
	
	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}
	
	
}
