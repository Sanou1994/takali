package com.connecsen.oterrain.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.dto.request.TournoiDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TournoiDtoResponse;
import com.connecsen.oterrain.service.ITournoiService;
import com.connecsen.oterrain.utils.Utility;

@RestController
public class TournoiController {
	private ITournoiService iTournoiService;
	
	public TournoiController(ITournoiService iTournoiService) {
		super();
		this.iTournoiService = iTournoiService;
	}


	@PostMapping(Utility.ADD_TOURNOI)
	public TournoiDtoResponse ajouterTournoi( @RequestBody TournoiDtoRequest tournoi) {
		TournoiDtoResponse tournoiAdd =iTournoiService.createOrUpdateTournoi(tournoi);
		return tournoiAdd;
	}
	@PutMapping(Utility.UPDATE_TOURNOI)
	public TournoiDtoResponse getUpdateUser( @RequestBody TournoiDtoRequest user){
		return iTournoiService.createOrUpdateTournoi(user);
    }
	@GetMapping(Utility.GET_ALL_TOURNOIS)
	public List<TournoiDtoResponse> getAllTournoi(){
		return iTournoiService.getAllTournois();
    }
	@GetMapping(Utility.GET_TOURNOI_BY_ID)
	public TournoiDtoResponse getTournoiById(@PathVariable(value = "id") Long userId){
		return iTournoiService.getTournoiById(userId);
    }
	@DeleteMapping(Utility.DELETE_TOURNOI_BY_ID)
	public boolean getDeleteTournoi(@PathVariable(value = "id") Long userId){
		return iTournoiService.deleteTournoi(userId);
    }
}
