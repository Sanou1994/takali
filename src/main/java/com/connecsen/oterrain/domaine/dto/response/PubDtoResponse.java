package com.connecsen.oterrain.domaine.dto.response;

import com.connecsen.oterrain.domaine.Multimedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class PubDtoResponse {
	private Long id;
	private String endroit;
	private String dateDebut;
	private String dateFin;
	private String urlPub;
	private Multimedia multimedia;
}
