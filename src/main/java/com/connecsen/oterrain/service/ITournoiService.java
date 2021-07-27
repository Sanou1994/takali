package com.connecsen.oterrain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.dto.request.TournoiDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TournoiDtoResponse;
@Service
public interface ITournoiService {
	   //GESTION TERRAINS
	  public TournoiDtoResponse createOrUpdateTournoi( TournoiDtoRequest tournoiDtoRequest);
	  public  TournoiDtoResponse getTournoiById(Long id);
	  public List<TournoiDtoResponse> getAllTournois();
	  public boolean deleteTournoi(Long id); 
}
