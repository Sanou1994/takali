package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.HomeOne;
import com.connecsen.oterrain.domaine.dto.request.HomeOneDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.HomeOneDtoResponse;
import com.connecsen.oterrain.exception.createexception.CreateEquipeException;
import com.connecsen.oterrain.exception.deleteexception.HomeOneDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.HomeOneNotFoundException;
import com.connecsen.oterrain.repository.HomeOneRepository;
import com.connecsen.oterrain.utils.Utility;
@Transactional
@Service
public class HomeOneService implements IHomeOneService{
	@Autowired
	private HomeOneRepository homeOneRepository;
	@Override
	public HomeOneDtoResponse createOrUpdateHomeOne(HomeOneDtoRequest tournoiDtoRequest) {
		HomeOneDtoResponse tournoiDtoResponse = null;
		try {
			HomeOne tournoi = Utility.homeOneDtoRequestConvertToHomeOne(tournoiDtoRequest);
			tournoiDtoResponse = Utility.homeOneConvertToHomeOneDtoResponse(homeOneRepository.save(tournoi));
			
		} catch (Exception e) {
			throw new CreateEquipeException(tournoiDtoRequest.getTitre());
		}
		return tournoiDtoResponse;
	}

	@Override
	public HomeOneDtoResponse getHomeOneById(Long id) {
		HomeOneDtoResponse tournoiDtoResponse = null;
		try {
			HomeOne tournoi = homeOneRepository.findById(id).get();
			tournoiDtoResponse = Utility.homeOneConvertToHomeOneDtoResponse(homeOneRepository.save(tournoi));
			
		} catch (Exception e) {
			throw new HomeOneNotFoundException(id);
		}
		return tournoiDtoResponse;
	}

	@Override
	public List<HomeOneDtoResponse> getAllHomeOnes() {
		List<HomeOne> tournois =homeOneRepository.findAll();
		 List<HomeOneDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.homeOneConvertToHomeOneDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteHomeOne(Long id) {
		boolean resultat = false;
		try {
			HomeOne tournoi = homeOneRepository.findById(id).get();
			if(tournoi != null) {
				homeOneRepository.deleteById(id);
				resultat =true;
			}	
		} catch (Exception e) {
			throw new HomeOneDeletedException(id);
		}
		
		
		return resultat;
	
	}

}
