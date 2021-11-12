package com.connecsen.oterrain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Indisponibilite;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.repository.IndisponibiliteRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
@Service
public class IndisponibiliteService implements IIndisponibiliteService{
     private IndisponibiliteRepository choosePeriodicDayRepository;
     private TerrainRepository terrainRepository;
     
	public IndisponibiliteService(TerrainRepository terrainRepository,IndisponibiliteRepository choosePeriodicDayRepository) {
		super();
		this.choosePeriodicDayRepository = choosePeriodicDayRepository;
		this.terrainRepository = terrainRepository;

	}

	@Override
	public Indisponibilite createIndisponibilite(Indisponibilite choosePeriodicDay) {
		// TODO Auto-generated method stub
		return choosePeriodicDayRepository.save(choosePeriodicDay);
	}

	@Override
	public Indisponibilite getIndisponibiliteById(Long id) {
		// TODO Auto-generated method stub
		return choosePeriodicDayRepository.findById(id).get();
	}

	@Override
	public List<Indisponibilite> getAllIndisponibilites() {
		// TODO Auto-generated method stub
		return choosePeriodicDayRepository.findAll();
	}

	@Override
	public void deleteIndisponibiliteDay(Long id) {
		choosePeriodicDayRepository.deleteById(id);
		
	}

	@Override
	public Terrain addIndisponibiliteToTerrain(Long idTerrain, Indisponibilite choosePeriodicDay) {
		Terrain terrain =terrainRepository.findById(idTerrain).get();
		choosePeriodicDay.setTerrain(terrain);
		Indisponibilite save =choosePeriodicDayRepository.save(choosePeriodicDay);
		terrain.setIndisponibilite(save);
		Terrain terrainSave =terrainRepository.save(terrain);
		return terrainSave;
	}

	@Override
	public Indisponibilite updateIndisponibilite(Indisponibilite choosePeriodicDay) {
		Indisponibilite save =null;
		if(choosePeriodicDay != null) {
			   if((choosePeriodicDay.getDay() !=null)&&(choosePeriodicDay.getHeure() !=null)){
				  save =choosePeriodicDayRepository.save(choosePeriodicDay);
				   
			   }else if((choosePeriodicDay.getDay() !=null)&&(choosePeriodicDay.getHeure() ==null)){
				   Indisponibilite saveGot = choosePeriodicDayRepository.findById(choosePeriodicDay.getId()).get();
				   saveGot.setDay(choosePeriodicDay.getDay());
				   save =choosePeriodicDayRepository.save(choosePeriodicDay);
			   }else if((choosePeriodicDay.getDay() ==null)&&(choosePeriodicDay.getHeure() !=null)){
				   Indisponibilite saveGot = choosePeriodicDayRepository.findById(choosePeriodicDay.getId()).get();
				   saveGot.setHeure(choosePeriodicDay.getHeure());
				   save =choosePeriodicDayRepository.save(choosePeriodicDay);
			   } 
		}
		
		return save;
	}


}
