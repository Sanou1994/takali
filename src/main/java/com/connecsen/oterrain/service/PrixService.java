package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Prix;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;
import com.connecsen.oterrain.domaine.dto.request.PrixDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.PrixDtoResponse;
import com.connecsen.oterrain.repository.PrixRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.TournoiRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
public class PrixService implements IPrixService{
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private TournoiRepository tournoiRepository;
	@Autowired
	private PrixRepository prixRepository;
	
	@Override
	public PrixDtoResponse createOrUpdatePrix(PrixDtoRequest tournoiDtoRequest) {
		Prix prix = Utility.prixDtoRequestConvertToPrix(tournoiDtoRequest);
		PrixDtoResponse tournoiDtoResponse = Utility.prixConvertToPrixDtoResponse(prixRepository.save(prix));
		return tournoiDtoResponse;
	}

	@Override
	public PrixDtoResponse getPrixById(Long id) {
		
		Prix tournoi = prixRepository.findById(id).get();
		PrixDtoResponse tournoiDtoResponse = Utility.prixConvertToPrixDtoResponse(prixRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public List<PrixDtoResponse> getAllPrix() {
		List<Prix> tournois =prixRepository.findAll();
		 List<PrixDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.prixConvertToPrixDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deletePrix(Long id) {
		boolean resultat = false;
		Prix tournoi = prixRepository.findById(id).get();
		if(tournoi != null) {
			prixRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	
	}

	@Override
	public PrixDtoResponse addPrixToTerrain(long idTerrain,
			PrixDtoRequest prixDtoRequest) {
		Prix prix = Utility.prixDtoRequestConvertToPrix(prixDtoRequest);
		Terrain terrain =terrainRepository.findById(idTerrain).get();
		prix.setTerrain(terrain);
		Prix prixGot = prixRepository.save(prix);
		terrain.getPrix().add(prixGot);
		terrainRepository.save(terrain);
		PrixDtoResponse prixDtoResponse = Utility. prixConvertToPrixDtoResponse( prixGot);
		return  prixDtoResponse;
	}

	@Override
	public PrixDtoResponse addPrixToTournoi(long idTournoi,
			PrixDtoRequest prixDtoRequest) {
		Prix prix = Utility.prixDtoRequestConvertToPrix(prixDtoRequest);
		Tournoi tournoi =tournoiRepository.findById(idTournoi).get();
		prix.setTournoi(tournoi);
		Prix prixGot = prixRepository.save(prix);
		tournoi.getPrix().add(prixGot);
		tournoiRepository.save(tournoi);
		PrixDtoResponse prixDtoResponse = Utility. prixConvertToPrixDtoResponse( prixGot);
		return  prixDtoResponse;
	}


}
