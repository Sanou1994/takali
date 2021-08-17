package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Tournoi;
import com.connecsen.oterrain.domaine.dto.request.TournoiDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TournoiDtoResponse;
import com.connecsen.oterrain.repository.TournoiRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
public class TournoiService implements ITournoiService{
private TournoiRepository tournoiRepository;
    
	public TournoiService(TournoiRepository tournoiRepository) {
		super();
		this.tournoiRepository = tournoiRepository;
	}

	@Override
	public TournoiDtoResponse createOrUpdateTournoi(TournoiDtoRequest tournoiDtoRequest) {
		Tournoi tournoi = Utility.tournoiDtoRequestConvertToTournoi(tournoiDtoRequest);
		TournoiDtoResponse tournoiDtoResponse = Utility.tournoiConvertToTournoiDtoResponse(tournoiRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public TournoiDtoResponse getTournoiById(Long id) {
		Tournoi tournoi = tournoiRepository.findById(id).get();
		TournoiDtoResponse tournoiDtoResponse = Utility.tournoiConvertToTournoiDtoResponse(tournoiRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public List<TournoiDtoResponse> getAllTournois() {
		List<Tournoi> tournois =tournoiRepository.findAll();
		 List<TournoiDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.tournoiConvertToTournoiDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteTournoi(Long id) {
		boolean resultat = false;
		Tournoi tournoi = tournoiRepository.findById(id).get();
		if(tournoi != null) {
			tournoiRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	}

}
