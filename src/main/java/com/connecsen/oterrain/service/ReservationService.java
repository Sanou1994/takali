package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.dto.request.ReservationDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.ReservationDtoResponse;
import com.connecsen.oterrain.repository.ReservationRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
public class ReservationService implements IReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	@Override
	public ReservationDtoResponse createOrUpdateReservation(ReservationDtoRequest tournoiDtoRequest) {
		Reservation tournoi = Utility.reservationDtoRequestConvertToReservation(tournoiDtoRequest);
		ReservationDtoResponse tournoiDtoResponse = Utility.reservationConvertToReservationDtoResponse(reservationRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public ReservationDtoResponse getReservationById(Long id) {
		
		Reservation tournoi = reservationRepository.findById(id).get();
		ReservationDtoResponse tournoiDtoResponse = Utility.reservationConvertToReservationDtoResponse(reservationRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public List<ReservationDtoResponse> getAllReservations() {
		List<Reservation> tournois =reservationRepository.findAll();
		 List<ReservationDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.reservationConvertToReservationDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteReservation(Long id) {
		boolean resultat = false;
		Reservation tournoi = reservationRepository.findById(id).get();
		if(tournoi != null) {
			reservationRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	
	}
}
