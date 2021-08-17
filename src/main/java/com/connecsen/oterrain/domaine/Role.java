package com.connecsen.oterrain.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author akane
 *
 */
@Entity @Data @NoArgsConstructor @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle ;
	@OneToMany(targetEntity=Utilisateur.class,mappedBy = "roles",fetch = FetchType.EAGER)
	private List<Utilisateur> users = new ArrayList<Utilisateur>();
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
