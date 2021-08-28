package com.connecsen.oterrain.domaine.dto.response;

import java.util.Date;
import java.util.List;

import com.connecsen.oterrain.domaine.Multimedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class PubDtoResponse {
	private Long id;
	private String endroit;
	private Date dateDebut;
	private Date dateFin;
	private List<Multimedia> multimedias;
}
