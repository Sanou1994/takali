package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.Versement;
import com.connecsen.oterrain.domaine.dto.request.VersementDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.VersementDtoResponse;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.repository.VersementRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
@Transactional
public class VersementService implements IVersementService{

	@Autowired
	private VersementRepository versementRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public VersementDtoResponse createOrUpdateVersement(VersementDtoRequest versementDtoRequest) {
		Versement versement = Utility.versementDtoRequestConvertToVersement(versementDtoRequest);
		VersementDtoResponse tournoiDtoResponse = Utility.versementConvertToVersementDtoResponse(versementRepository.save(versement));
		return tournoiDtoResponse;
	}

	@Override
	public VersementDtoResponse getVersementById(Long id) {
		
		Versement versement = versementRepository.findById(id).get();
		VersementDtoResponse versementDtoResponse = Utility.versementConvertToVersementDtoResponse(versementRepository.save(versement));
		return versementDtoResponse;
	}

	@Override
	public List<VersementDtoResponse> getAllVersements() {
		List<Versement> versements =versementRepository.findAll();
		 List<VersementDtoResponse> versementDtoResponses = versements.stream()
				 .map(versement -> Utility.versementConvertToVersementDtoResponse(versement)).collect(Collectors.toList());
		return versementDtoResponses;
	}

	@Override
	public boolean deleteVersement(Long id) {
		boolean resultat = false;
		Versement tournoi = versementRepository.findById(id).get();
		if(tournoi != null) {
			versementRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	
	}

	@Override
	public List<VersementDtoResponse> getVersementByUser(long idUser) {
		Utilisateur user =userRepository.findById(idUser).get();
		 List<VersementDtoResponse> VersementDtoResponses = user.getVersements().stream()
				 .map(versement -> Utility.versementConvertToVersementDtoResponse(versement)).collect(Collectors.toList());
		return VersementDtoResponses;
	}


	@Override
	public VersementDtoResponse addVersementToUser(long idUser, 
			VersementDtoRequest VersementDtoRequest) {
		Versement Versement = Utility.versementDtoRequestConvertToVersement(VersementDtoRequest);
		Utilisateur user =userRepository.findById(idUser).get();
		Versement.setUser(user);
		Versement VersementGot = versementRepository.save(Versement);
		user.getVersements().add(VersementGot);
		userRepository.save(user);
		VersementDtoResponse VersementDtoResponse = Utility.versementConvertToVersementDtoResponse(VersementGot);
		return VersementDtoResponse;
	}



}
