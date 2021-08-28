package com.connecsen.oterrain.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.dto.request.TerrainDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;
import com.connecsen.oterrain.service.ITerrainService;
import com.connecsen.oterrain.utils.Utility;

@RestController
public class TerrainController {
	private ITerrainService iTerrainService;
	public TerrainController(ITerrainService iTerrainService) {
		super();
		this.iTerrainService = iTerrainService;
	}


	@PostMapping(Utility.ADD_TERRAIN)
	public TerrainDtoResponse ajouterTerrain( @RequestBody TerrainDtoRequest terrain) {
		TerrainDtoResponse terrainAdd =iTerrainService.createOrUpdateTerrain(terrain);
		return terrainAdd;
	}
	@PostMapping(Utility.UPDATE_TERRAIN)
	public TerrainDtoResponse getUpdateUser( @RequestBody TerrainDtoRequest user){
		return iTerrainService.createOrUpdateTerrain(user);
    }
	@GetMapping(Utility.GET_ALL_TERRAINS)
	public List<TerrainDtoResponse> getAllTerrain(){
		return iTerrainService.getAllTerrains();
    }
	@GetMapping(Utility.GET_TERRAIN_BY_ID)
	public TerrainDtoResponse getTerrainById(@PathVariable(value = "id") Long userId){
		return iTerrainService.getTerrainById(userId);
    }
	@GetMapping(Utility.DELETE_TERRAIN_BY_ID)
	public boolean getDeleteTerrain(@PathVariable(value = "id") Long userId){
		return iTerrainService.deleteTerrain(userId);
    }
}
