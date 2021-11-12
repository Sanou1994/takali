package com.connecsen.oterrain.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.Indisponibilite;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.service.IIndisponibiliteService;
import com.connecsen.oterrain.utils.Utility;
@RestController
public class IndisponibiliteRestController {
	@Autowired
	private IIndisponibiliteService iIndisponibiliteService;
	@PostMapping(Utility.ADD_INDISPONIBILITE)
	public Indisponibilite ajouterIndisponibilite( @RequestBody Indisponibilite choosePeriodicDay) {
		Indisponibilite indisponibilite =iIndisponibiliteService.createIndisponibilite(choosePeriodicDay);
		return indisponibilite;
	}
	@PostMapping(Utility.UPDATE_INDISPONIBILITE)
	public Indisponibilite modifierIndisponibilite( @RequestBody Indisponibilite choosePeriodicDay) {
		Indisponibilite indisponibilite =iIndisponibiliteService.updateIndisponibilite(choosePeriodicDay);
		return indisponibilite;
	}
	
	@PostMapping(Utility.ADD_INDISPONIBILITE_TO_TERRAIN)
	public Terrain ajouterIndisponibiliteTerrain(@PathVariable(value ="id") Long idTerrain, @RequestBody Indisponibilite choosePeriodicDay) {
		Terrain terrain =iIndisponibiliteService.addIndisponibiliteToTerrain(idTerrain, choosePeriodicDay);
		return terrain;
	}
	
	@GetMapping(Utility.GET_INDISPONIBILITE_BY_ID)
	public Indisponibilite getIndisponibiliteById(@PathVariable(value = "id") Long userId){
		return iIndisponibiliteService.getIndisponibiliteById(userId);
    }
	@GetMapping(Utility.DELETE_INDISPONIBILITE_BY_ID)
	public void getDeleteIndisponibilite(@PathVariable(value = "id") Long userId){
		iIndisponibiliteService.deleteIndisponibiliteDay(userId);
    }
	@GetMapping(Utility.GET_ALL_INDISPONIBILITES)
	public List<Indisponibilite> getAllIndisponibilites(){
		return iIndisponibiliteService.getAllIndisponibilites();
    }
}
