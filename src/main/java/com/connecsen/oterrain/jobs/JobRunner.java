package com.connecsen.oterrain.jobs;

import java.util.List;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.service.IReservationService;

public class JobRunner implements Runnable{
    private IReservationService iReservationService;
    private TerrainRepository terrainRepository;
    private UserRepository userRepository;
    public JobRunner() {
		super();
	}

	public JobRunner(IReservationService iReservationService,
			TerrainRepository terrainRepository,
			UserRepository userRepository) {
		super();
		this.iReservationService = iReservationService;
		this.terrainRepository = terrainRepository;
		this.userRepository = userRepository;
	}
    public void checkReservation(List<Reservation> reservations) {
    	System.out.println(" reservation tailles :"+reservations.size());
    	for (int i = 0; i < reservations.size(); i++) {
			if(reservations.get(i).getStatePayement().equals("PENDING")) {
				System.out.println(" reservation est supprimer :"+reservations.get(i).getId());
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
