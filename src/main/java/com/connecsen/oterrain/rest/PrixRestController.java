package com.connecsen.oterrain.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.dto.request.PrixDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.PrixDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.TournoiDtoResponse;
import com.connecsen.oterrain.service.IPrixService;
import com.connecsen.oterrain.service.ITerrainService;
import com.connecsen.oterrain.service.ITournoiService;
import com.connecsen.oterrain.utils.Utility;
@RestController
public class PrixRestController {
	Logger logger = LoggerFactory.getLogger(PrixRestController.class);
	@Autowired
	private IPrixService iPrixService;
	@Autowired
	private ITerrainService terrainService;
	@Autowired
	private ITournoiService tournoiService;
	
	@PostMapping(Utility.ADD_PRIX)
	public PrixDtoResponse ajouterPrix( @RequestBody PrixDtoRequest versement) {
		PrixDtoResponse versementAdd =iPrixService.createOrUpdatePrix(versement);
		return versementAdd;
	}
	@PostMapping(Utility.UPDATE_PRIX)
	public PrixDtoResponse getUpdatePrix( @RequestBody PrixDtoRequest versement){
		return iPrixService.createOrUpdatePrix(versement);
    }
	@GetMapping(Utility.GET_ALL_PRIX)
	public List<PrixDtoResponse> getAllPrix(){
		return iPrixService.getAllPrix();
    }
	@GetMapping(Utility.GET_PRIX_BY_ID)
	public PrixDtoResponse getPrixById(@PathVariable(value = "id") Long userId){
		return iPrixService.getPrixById(userId);
    }
	@GetMapping(Utility.DELETE_PRIX_BY_ID)
	public boolean getDeletePrix(@PathVariable(value = "id") Long userId){
		return iPrixService.deletePrix(userId);
    }
	 @PostMapping(Utility.ADD_PRIX_TO_TERRAIN)
		public PrixDtoResponse getAddPrixToTerrain( @PathVariable(value = "idTerrain") Long idTerrain, @RequestBody PrixDtoRequest prixDtoRequest){
		 TerrainDtoResponse terrainBefore =terrainService.getTerrainById(idTerrain);
		 PrixDtoResponse resultatVersement = iPrixService.addPrixToTerrain(idTerrain,prixDtoRequest);
		 TerrainDtoResponse terrainGot =terrainService.getTerrainById(idTerrain);
		String succesResultat ="echec";
			if(terrainBefore.getPrix().size() !=terrainGot.getPrix().size()) {
				succesResultat = "success";
			}
	logger.info(" we add the price : "+ prixDtoRequest.getValeur()+" of the terrain :" +terrainBefore.getNom()+" with : "+succesResultat);
			return resultatVersement ;
	    }
	 
	 @PostMapping(Utility.ADD_PRIX_TO_TOURNOI)
		public PrixDtoResponse getAddPrixToTournoi( @PathVariable(value = "idTournoi") Long idTournoi, @RequestBody PrixDtoRequest prixDtoRequest){
		 TournoiDtoResponse tournoiBefore =tournoiService.getTournoiById(idTournoi);
		 PrixDtoResponse resultatVersement = iPrixService.addPrixToTournoi(idTournoi,prixDtoRequest);
		 TournoiDtoResponse tournoiGot =tournoiService.getTournoiById(idTournoi);
		String succesResultat ="echec";
			if(tournoiBefore.getPrix().size() !=tournoiGot.getPrix().size()) {
				succesResultat = "success";
			}
	logger.info(" we add the price : "+ prixDtoRequest.getValeur()+" of the tournoi :" +tournoiBefore.getNom()+" with : "+succesResultat);
			return resultatVersement ;
	    }
	 
}
