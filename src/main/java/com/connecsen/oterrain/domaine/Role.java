package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author akane
 *
 */
@Entity @Data @NoArgsConstructor 
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle ;
	@OneToMany
	private Collection<Utilisateur> users = new ArrayList<Utilisateur>();
	public Role(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}

}
