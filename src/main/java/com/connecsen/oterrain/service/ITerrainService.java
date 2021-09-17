package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.Reserver;
import com.connecsen.oterrain.domaine.dto.request.ReservationDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.TerrainDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;

public interface ITerrainService {
	      //GESTION TERRAINS
		  public TerrainDtoResponse createOrUpdateTerrain( TerrainDtoRequest terrainDtoRequest);
		  public TerrainDtoResponse addReservationToTerrain( long idTerrain,ReservationDtoRequest reservationDtoRequest);
		  public  TerrainDtoResponse getTerrainById(Long id);
		  public List<TerrainDtoResponse> getAllTerrains();
		  public boolean deleteTerrain(Long id); 
		  public List<String> getHoursBusyByTerrainAndMonthAndDay(Reserver reserver);
		 
}
