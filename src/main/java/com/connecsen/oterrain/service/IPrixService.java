package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.dto.request.PrixDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.PrixDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;

public interface IPrixService {
	//GESTION PRIX
	  public PrixDtoResponse createOrUpdatePrix( PrixDtoRequest prixDtoRequest);
	  public TerrainDtoResponse updatePrix(long idTerrain, PrixDtoRequest prixDtoRequest);
	  public  PrixDtoResponse getPrixById(Long id);
	  public List<PrixDtoResponse> getAllPrix();
	  public boolean deletePrix(Long id);
	  public PrixDtoResponse addPrixToTerrain( long idTerrain,PrixDtoRequest prix);

}
