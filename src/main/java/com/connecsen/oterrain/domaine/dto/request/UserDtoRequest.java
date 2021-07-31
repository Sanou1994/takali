package com.connecsen.oterrain.domaine.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class UserDtoRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String prenom;
	private String adresse;
	private String typeId;
	private String numeroId;
	private String naissance;
	private String email;
	private String telephone;
	private String monToken;
	private String password;
    private String resetPasswordToken;
	private Role roles ;
	private Collection<Terrain> terrains = new ArrayList<Terrain>();
	private Collection<Reservation> reservations = new ArrayList<Reservation>();
	
}