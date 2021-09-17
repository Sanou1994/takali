package com.connecsen.oterrain.domaine.dto.request;

import com.connecsen.oterrain.domaine.Multimedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PubDtoRequest {
	private Long id;
	private String endroit;
	private String dateDebut;
	private String dateFin;
	private String urlPub;
	private Multimedia multimedia;
}
