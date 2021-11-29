package com.connecsen.oterrain.jobs;

import java.util.List;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.service.IReservationService;

public class JobRunner implements Runnable{
    private IReservationService iReservationService;
    private TerrainRepository terrainRepository;
    public JobRunner() {
		super();
	}

	public JobRunner(IReservationService iReservationService,
			TerrainRepository terrainRepository) {
		super();
		this.iReservationService = iReservationService;
		this.terrainRepository = terrainRepository;
	}
    public void checkReservation(List<Reservation> reservations) {
    	System.out.println("je suis job");
    	for (int i = 0; i < reservations.size(); i++) {
			if(reservations.get(i).getStatePayement().equals("PENDING")) {
				
				Terrain terrain=terrainRepository.findById(reservations.get(i).getIdTerrain()).get();
				iReservationService.deleteReservationByIdUserAndIdTerrain(terrain.getIdUser(), reservations.get(i).getIdTerrain(), reservations.get(i));
			}
		}
    }
    
	@Override
    public void run() {
		checkReservation(iReservationService.getAllReservations());	
    }
}
