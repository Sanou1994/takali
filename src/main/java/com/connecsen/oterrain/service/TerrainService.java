package com.connecsen.oterrain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Indisponibilite;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Reserver;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.TerrainDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;
import com.connecsen.oterrain.exception.createexception.CreateTerrainException;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
@Transactional
public class TerrainService implements ITerrainService {
    private TerrainRepository terrainRepository;
    private UserRepository userRepository;
    
	public TerrainService(TerrainRepository terrainRepository,UserRepository userRepository) {
		super();
		this.terrainRepository = terrainRepository;
		this.userRepository = userRepository;
	}

	@Override
	public TerrainDtoResponse createOrUpdateTerrain(long id,TerrainDtoRequest terrainDtoRequest) {
		TerrainDtoResponse terrainDtoResponse =null;
		try {
			terrainDtoRequest.setIdUser(id);
			Terrain terrain = Utility.terrainDtoRequestConvertToTerrain(terrainDtoRequest);
			Utilisateur user = userRepository.findById(id).get();
			user.getTerrains().add(terrain);
			Utilisateur userSave = userRepository.save(user);
			terrain.setUser(userSave);
			Terrain terrainT =terrainRepository.save(terrain);
			terrainDtoResponse = Utility.terrainConvertToTerrainDtoResponse(terrainRepository.save(terrainT));
			
		} catch (Exception e) {
			throw new CreateTerrainException(terrainDtoRequest.getNom());
		}
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
	public TerrainDtoResponse addReservationToTerrain(long idTerrain, Reservation reservation) {
		Terrain terrain = terrainRepository.findById(idTerrain).get();
		reservation.setTerrain(terrain);
		terrain.getReservations().add(reservation);
		TerrainDtoResponse terrainDtoResponse = Utility.terrainConvertToTerrainDtoResponse(terrainRepository.save(terrain));
		return terrainDtoResponse;
	}

	@Override
	public List<String> getHoursBusyByTerrainAndMonthAndDay(Reserver reserver) {
		List<String> heures= new ArrayList<String>();
		boolean testHeure =false;
		Terrain terrain = terrainRepository.findById(reserver.getIdTerrain()).get();
		Indisponibilite indisponibilite = terrain.getIndisponibilite();
		String[]  date =reserver.getDate().split("/");
		
		if(indisponibilite != null) {
			String[]  heurePrecises =indisponibilite.getDatePrecise().split("/");
			/*indisponibilite.getDays()!= null
			 * indisponibilite.getHeures()!= null
			 * indisponibilite.getDatePrecise()!= null
			 * ###################################################################################*/
			if((indisponibilite.getDays()!= null)&&(indisponibilite.getHeures()!= null)
					&&(indisponibilite.getDatePrecise()!= null)){
				
			for (int i = 0; i < indisponibilite.getDays().size(); i++) {
								
								if(indisponibilite.getDays().get(i) == Integer.parseInt(date[0])) {
									 testHeure =true;
								}
							}
						

			if((!testHeure)&&(heurePrecises[0]==date[1])
					&&(heurePrecises[1]==date[2])
					&&(heurePrecises[2]==date[3])
					) {
						heures=indisponibilite.getHeures();
						
						for (int i = 0; i < indisponibilite.getHeurePrecises().size(); i++) {
							
							heures.add(indisponibilite.getHeurePrecises().get(i));
						}
							
			}else if((!testHeure)&&((heurePrecises[0]!=date[1])
					|| (heurePrecises[1]!=date[2])
					|| (heurePrecises[2]!=date[3])
					)) {
						heures=indisponibilite.getHeures();
							
			}
			
			
			}
			
			/*indisponibilite.getDays()== null
			 * indisponibilite.getHeures()!= null
			 * indisponibilite.getDatePrecise()!= null
			*###################################################################################*/
			
			if((indisponibilite.getDays()== null)&&(indisponibilite.getHeures()!= null)
			         &&(indisponibilite.getHeurePrecises() != null) &&(indisponibilite.getDatePrecise()!= null)){
				
			
			
			
			
			}
			
			/*###################################################################################*/
			if((indisponibilite.getDays()!= null)&&(indisponibilite.getHeures()!= null)
					&&(indisponibilite.getHeurePrecises() != null) &&(indisponibilite.getDatePrecise()!= null)){
				
			}
			
			/*###################################################################################*/
			if((indisponibilite.getDays()!= null)&&(indisponibilite.getHeures()!= null)
					&&(indisponibilite.getHeurePrecises() != null) &&(indisponibilite.getDatePrecise()!= null)){
				
			}
			
			/*###################################################################################*/
			if((indisponibilite.getDays()!= null)&&(indisponibilite.getHeures()!= null)
					&&(indisponibilite.getHeurePrecises() != null) &&(indisponibilite.getDatePrecise()!= null)){
				
			}
			
			/*###################################################################################*/
			if((indisponibilite.getDays()!= null)&&(indisponibilite.getHeures()!= null)
					&&(indisponibilite.getHeurePrecises() != null) &&(indisponibilite.getDatePrecise()!= null)){
				
			}
			
			
				
	} 
		
		
       for (int i = 0; i < terrain.getListeHeureReserver().size(); i++) {
			
    	   if((terrain.getListeHeureReserver().get(i).getNumeroMois()==Long.parseLong(date[2]))
    			   &&(terrain.getListeHeureReserver().get(i).getNumeroJour()==Long.parseLong(date[1]))) {
				heures.add(terrain.getListeHeureReserver().get(i).getHeure());
			}
		}
		

		return heures;
	}

}