package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.dto.request.ReservationDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.ReservationDtoResponse;

public interface IReservationService {
	 //GESTION EQUIPES
	  public ReservationDtoResponse createOrUpdateReservation(ReservationDtoRequest reservationDtoRequest);
	  public  ReservationDtoResponse getReservationById(Long id);
	  public List<ReservationDtoResponse> getAllReservations();
	  public boolean deleteReservation(Long id); 
}
