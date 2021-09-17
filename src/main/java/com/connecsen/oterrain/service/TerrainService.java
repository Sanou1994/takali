package com.connecsen.oterrain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Reserver;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.dto.request.ReservationDtoRequest;
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
		Terrain terrainT =terrainRepository.save(terrain);
		TerrainDtoResponse terrainDtoResponse = Utility.terrainConvertToTerrainDtoResponse(terrainRepository.save(terrainT));
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

	@Override
	public TerrainDtoResponse addReservationToTerrain(long idTerrain, ReservationDtoRequest reservationDtoRequest) {
		Reservation reservation = Utility.reservationDtoRequestConvertToReservation(reservationDtoRequest);
		Terrain terrain = terrainRepository.findById(idTerrain).get();
		reservation.setTerrain(terrain);
		terrain.getReservations().add(reservation);
		TerrainDtoResponse terrainDtoResponse = Utility.terrainConvertToTerrainDtoResponse(terrainRepository.save(terrain));
		return terrainDtoResponse;
	}

	@Override
	public List<String> getHoursBusyByTerrainAndMonthAndDay(Reserver reserver) {
		Terrain terrain = terrainRepository.findById(reserver.getIdTerrain()).get();
		String[]  date =reserver.getDate().split("/");
		List<String> heures = new ArrayList<String>();
		terrain.getListeHeureReserver().forEach(
				res ->{
					if((res.getNumeroMois()==Long.parseLong(date[1]))&&(res.getNumeroJour()==Long.parseLong(date[0]))) {
						heures.add(res.getHeure());
					}
				});
		return heures;
	}

}