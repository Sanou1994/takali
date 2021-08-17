package com.connecsen.oterrain.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.dto.request.ReservationDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.ReservationDtoResponse;
import com.connecsen.oterrain.service.IReservationService;
import com.connecsen.oterrain.utils.Utility;
@RestController
public class ReservationRestController {
	@Autowired
	private IReservationService iReservationService;
	
	@PostMapping(Utility.ADD_RESERVATION)
	public ReservationDtoResponse ajouterTournoi( @RequestBody ReservationDtoRequest tournoi) {
		ReservationDtoResponse tournoiAdd =iReservationService.createOrUpdateReservation(tournoi);
		return tournoiAdd;
	}
	@PostMapping(Utility.UPDATE_RESERVATION)
	public ReservationDtoResponse getUpdateUser( @RequestBody ReservationDtoRequest user){
		return iReservationService.createOrUpdateReservation(user);
    }
	@GetMapping(Utility.GET_ALL_RESERVATIONS)
	public List<ReservationDtoResponse> getAllTournoi(){
		return iReservationService.getAllReservations();
    }
	@GetMapping(Utility.GET_RESERVATION_BY_ID)
	public ReservationDtoResponse getTournoiById(@PathVariable(value = "id") Long userId){
		return iReservationService.getReservationById(userId);
    }
	@DeleteMapping(Utility.DELETE_RESERVATION_BY_ID)
	public boolean getDeleteTournoi(@PathVariable(value = "id") Long userId){
		return iReservationService.deleteReservation(userId);
    }
}
