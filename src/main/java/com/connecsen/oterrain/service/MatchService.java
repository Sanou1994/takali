package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.dto.request.MatchDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.MatchDtoResponse;
import com.connecsen.oterrain.repository.MatchRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
public class MatchService implements IMatchService{

	@Autowired
	private MatchRepository matchRepository;
	@Override
	public MatchDtoResponse createOrUpdateMatch(MatchDtoRequest tournoiDtoRequest) {
		Match tournoi = Utility.MatchDtoRequestConvertToMatch(tournoiDtoRequest);
		MatchDtoResponse tournoiDtoResponse = Utility.matchConvertToMatchDtoResponse(matchRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public MatchDtoResponse getMatchById(Long id) {
		
		Match tournoi = matchRepository.findById(id).get();
		MatchDtoResponse tournoiDtoResponse = Utility.matchConvertToMatchDtoResponse(matchRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public List<MatchDtoResponse> getAllMatchs() {
		List<Match> tournois =matchRepository.findAll();
		 List<MatchDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.matchConvertToMatchDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteMatch(Long id) {
		boolean resultat = false;
		Match tournoi = matchRepository.findById(id).get();
		if(tournoi != null) {
			matchRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	
	}

}
