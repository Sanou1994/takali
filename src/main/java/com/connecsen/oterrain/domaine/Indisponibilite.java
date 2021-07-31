package com.connecsen.oterrain.domaine;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class Indisponibilite implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String date;
	private String heure;

}
