package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.dto.request.TerrainDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;

public interface ITerrainService {
	      //GESTION TERRAINS
		  public TerrainDtoResponse createOrUpdateTerrain( TerrainDtoRequest terrainDtoRequest);
		  public  TerrainDtoResponse getTerrainById(Long id);
		  public List<TerrainDtoResponse> getAllTerrains();
		  public boolean deleteTerrain(Long id); 
		 
}
