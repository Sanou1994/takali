package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author akane
 *
 */
@Entity
public class User implements Serializable {
	
	private Long id;
	private String slug;
	private String nom;

}
