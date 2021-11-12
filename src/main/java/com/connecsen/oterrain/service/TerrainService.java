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
	       ArrayList<String> heures = new ArrayList<String>();
			
			Terrain terrain = terrainRepository.findById(reserver.getIdTerrain()).get();
			String[]  date =reserver.getDate().split("/");
			if(terrain.getIndisponibilite()!=null) {
				Indisponibilite Disponibilite =terrain.getIndisponibilite();
				if((Disponibilite.getDay() !=null)) {
					String[]  day =Disponibilite.getDay().split(",");
					boolean resultat = false;
					// tester jour
					for (int i = 0; i < day.length; i++) {
						
						if(day[i].equals(date[0])) {
							resultat =true;
						}
					}
					
					if(!resultat) {
						if(Disponibilite.getHeure() !=null) {
							String[]  heure =Disponibilite.getHeure().split(",");
							for (int i = 0; i < heure.length; i++) {
								
								heures.add(heure[i]);
							}
							
							terrain.getListeHeureReserver().forEach(
									res ->{
										if((res.getNumeroMois()==Long.parseLong(date[2]))&&(res.getNumeroJour()==Long.parseLong(date[1]))) {
											heures.add(res.getHeure());
										}
									});
							
						}else {
							terrain.getListeHeureReserver().forEach(
									res ->{
										if((res.getNumeroMois()==Long.parseLong(date[2]))&&(res.getNumeroJour()==Long.parseLong(date[1]))) {
											heures.add(res.getHeure());
										}
									});
						}
						
					}
								
					
				}else {
					
					String[]  heure =Disponibilite.getHeure().split(",");
					for (int i = 0; i < heure.length; i++) {
						
						heures.add(heure[i]);
					}
					
					terrain.getListeHeureReserver().forEach(
							res ->{
								if((res.getNumeroMois()==Long.parseLong(date[2]))&&(res.getNumeroJour()==Long.parseLong(date[1]))) {
									heures.add(res.getHeure());
								}
							});
					
					
					
				}
				
			}else if(terrain.getListeHeureReserver() !=null){
				terrain.getListeHeureReserver().forEach(
						res ->{
							if((res.getNumeroMois()==Long.parseLong(date[2]))&&(res.getNumeroJour()==Long.parseLong(date[1]))) {
								heures.add(res.getHeure());
							}
						});	
			}else {
				heures.add("aucune disponbilite et aucune reservation");
			}
			
			return heures;
		}


}