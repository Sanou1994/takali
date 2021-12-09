package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Fichier;
import com.connecsen.oterrain.domaine.dto.request.FichierDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.FichierDtoResponse;
import com.connecsen.oterrain.exception.createexception.CreateFichierException;
import com.connecsen.oterrain.exception.deleteexception.FichierDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.FichierNotFoundException;
import com.connecsen.oterrain.repository.FichierRepository;
import com.connecsen.oterrain.utils.Utility;
@Transactional
@Service
public class FichierService implements IFichierService{
	@Autowired
	private FichierRepository fichierRepository;
	@Override
	public FichierDtoResponse createOrUpdateFichier(FichierDtoRequest tournoiDtoRequest) {
		FichierDtoResponse tournoiDtoResponse = null;
		try {
			Fichier tournoi = Utility.fichierDtoRequestConvertToFichier(tournoiDtoRequest);
			 tournoiDtoResponse = Utility.fichierConvertToFichierDtoResponse(fichierRepository.save(tournoi));
				
		} catch (Exception e) {
			throw new CreateFichierException(tournoiDtoRequest.getTypeFichier());
		}
		return tournoiDtoResponse;
	}

	@Override
	public FichierDtoResponse getFichierById(Long id) {
		FichierDtoResponse tournoiDtoResponse = null;
		try {
			Fichier tournoi = fichierRepository.findById(id).get();
			 tournoiDtoResponse = Utility.fichierConvertToFichierDtoResponse(fichierRepository.save(tournoi));	
		} catch (Exception e) {
			throw new FichierNotFoundException(id);
		}
			return tournoiDtoResponse;
	}

	@Override
	public List<FichierDtoResponse> getAllFichiers() {
		List<Fichier> tournois =fichierRepository.findAll();
		 List<FichierDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.fichierConvertToFichierDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteFichier(Long id) {
		boolean resultat = false;
		try {
			Fichier tournoi = fichierRepository.findById(id).get();
			if(tournoi != null) {
				fichierRepository.deleteById(id);
				resultat =true;
			}
		} catch (Exception e) {
			throw new FichierDeletedException(id);
		}
		
		return resultat;
	
	}


}
