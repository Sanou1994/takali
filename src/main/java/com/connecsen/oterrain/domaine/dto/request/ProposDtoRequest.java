package com.connecsen.oterrain.domaine.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProposDtoRequest {
	private Long id;
	private String titre;
	private String urlVideo;
	private String text;
}
