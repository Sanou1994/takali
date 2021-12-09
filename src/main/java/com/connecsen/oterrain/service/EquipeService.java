package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.UpdateEquipe;
import com.connecsen.oterrain.domaine.dto.request.EquipeDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.EquipeDtoResponse;
import com.connecsen.oterrain.exception.createexception.CreateEquipeException;
import com.connecsen.oterrain.exception.deleteexception.EquipeDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.EquipeNotFoundException;
import com.connecsen.oterrain.repository.EquipeRepository;
import com.connecsen.oterrain.utils.Utility;
@Transactional
@Service
public class EquipeService implements IEquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	@Override
	public EquipeDtoResponse createOrUpdateEquipe(EquipeDtoRequest tournoiDtoRequest) {
		EquipeDtoResponse tournoiDtoResponse =null;
		try {
			Equipe tournoi = Utility.equipeDtoRequestConvertToEquipe(tournoiDtoRequest);
			tournoiDtoResponse = Utility.equipeConvertToEquipeDtoResponse(equipeRepository.save(tournoi));
				
		} catch (Exception e) {
			throw new CreateEquipeException(tournoiDtoRequest.getNomEquipe());
		}
		return tournoiDtoResponse;
	}

	@Override
	public EquipeDtoResponse getEquipeById(Long id) {
		EquipeDtoResponse tournoiDtoResponse = null;
		try {
			Equipe tournoi = equipeRepository.findById(id).get();
			tournoiDtoResponse = Utility.equipeConvertToEquipeDtoResponse(equipeRepository.save(tournoi));
				
		} catch (Exception e) {
			throw new EquipeNotFoundException(id);
		}
		return tournoiDtoResponse;
	}

	@Override
	public List<EquipeDtoResponse> getAllEquipes() {
		List<Equipe> tournois =equipeRepository.findAll();
		 List<EquipeDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.equipeConvertToEquipeDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteEquipe(Long id) {
		boolean resultat = false;
		try {
			Equipe tournoi = equipeRepository.findById(id).get();
			if(tournoi != null) {
				equipeRepository.deleteById(id);
				resultat =true;
			}	
		} catch (Exception e) {
			throw new EquipeDeletedException(id);
		}
		return resultat;
	
	}

	@Override
	public EquipeDtoResponse updateEquipeByPaye(UpdateEquipe updateEquipe) {
		EquipeDtoResponse tournoiDtoResponse =null;
		try {
			Equipe tournoi = equipeRepository.findById(updateEquipe.getId()).get();
			tournoi.setPaye(updateEquipe.isPaye());
			tournoiDtoResponse = Utility.equipeConvertToEquipeDtoResponse(equipeRepository.save(tournoi));
				
		} catch (Exception e) {
			throw new CreateEquipeException(tournoiDtoResponse.getNomEquipe());
		}
		return tournoiDtoResponse;

	}

}
