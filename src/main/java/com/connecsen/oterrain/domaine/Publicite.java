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
import javax.persistence.OneToMany;
@Entity

public class Publicite implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endroit;
	private Date dateDebut;
	private Date dateFin;
	@OneToMany(cascade =CascadeType.PERSIST,mappedBy = "publicite")
	private List<Multimedia> multimedias = new ArrayList<Multimedia>();;
	
	public Publicite() {
		super();
	}
	public Publicite(String endroit, Date dateDebut, Date dateFin, List<Multimedia> multimedias) {
		super();
		this.endroit = endroit;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.multimedias = multimedias;
	}
	public Publicite(Long id, String endroit, Date dateDebut, Date dateFin, List<Multimedia> multimedias) {
		super();
		this.id = id;
		this.endroit = endroit;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.multimedias = multimedias;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEndroit() {
		return endroit;
	}
	public void setEndroit(String endroit) {
		this.endroit = endroit;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public List<Multimedia> getMultimedias() {
		return multimedias;
	}
	public void setMultimedias(List<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}
	
}
