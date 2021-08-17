package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.dto.request.TerrainDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
public class TerrainService implements ITerrainService {
    private TerrainRepository terrainRepository;
    
	public TerrainService(TerrainRepository terrainRepository) {
		super();
		this.terrainRepository = terrainRepository;
	}

	@Override
	public TerrainDtoResponse createOrUpdateTerrain(TerrainDtoRequest terrainDtoRequest) {
		Terrain terrain = Utility.terrainDtoRequestConvertToTerrain(terrainDtoRequest);
		TerrainDtoResponse terrainDtoResponse = Utility.terrainConvertToTerrainDtoResponse(terrainRepository.save(terrain));
		return terrainDtoResponse;
	}

	@Override
	public TerrainDtoResponse getTerrainById(Long id) {
		Terrain terrain = terrainRepository.findById(id).get();
		TerrainDtoResponse terrainDtoResponse = Utility.terrainConvertToTerrainDtoResponse(terrainRepository.save(terrain));
		return terrainDtoResponse;
	}

	@Override
	public List<TerrainDtoResponse> getAllTerrains() {
		List<Terrain> terrains =terrainRepository.findAll();
		 List<TerrainDtoResponse> terrainDtoResponses = terrains.stream()
				 .map(utilisateur -> Utility.terrainConvertToTerrainDtoResponse(utilisateur)).collect(Collectors.toList());
		return terrainDtoResponses;
	}

	@Override
	public boolean deleteTerrain(Long id) {
		boolean resultat = false;
		Terrain terrain = terrainRepository.findById(id).get();
		if(terrain != null) {
			terrainRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	}

}