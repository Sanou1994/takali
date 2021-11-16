package com.connecsen.oterrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.UpdateReservation;
import com.connecsen.oterrain.exception.createexception.CreateReservationException;
import com.connecsen.oterrain.exception.deleteexception.ReservationDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.ReservationNotFoundException;
import com.connecsen.oterrain.repository.ReservationRepository;
@Service
public class ReservationService implements IReservationService{
	@Autowired
	private IAccountService accountService;
	@Autowired
	private ReservationRepository reservationRepository;
	@Override
	public Reservation createOrUpdateReservation(Reservation tournoiDtoRequest) {
		Reservation tournoiDtoResponse =null;
		try {
			tournoiDtoResponse = reservationRepository.save(tournoiDtoRequest);

		} catch (Exception e) {
			throw new CreateReservationException(Long.toString(tournoiDtoRequest.getId()));
		}
		return tournoiDtoResponse;
	}

	@Override
	public Reservation getReservationById(Long id) {
		Reservation tournoiDtoResponse = null;
		try {
			Reservation tournoi = reservationRepository.findById(id).get();
			tournoiDtoResponse = reservationRepository.save(tournoi);
				
		} catch (Exception e) {
			throw new ReservationNotFoundException(id);
		}
		return tournoiDtoResponse;
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public boolean deleteReservation(Long id) {
		boolean resultat = false;
		try {
			Reservation tournoi = reservationRepository.findById(id).get();
			if(tournoi != null) {
				reservationRepository.deleteById(id);
				resultat =true;
			}
		} catch (Exception e) {
			throw new ReservationDeletedException(id);
		}
		
		return resultat;
	
	}

	@Override
	public Reservation updateReservationByStatus(UpdateReservation updateReservation) {
		Reservation tournoiDtoResponse =null;
		try {
			Reservation reservation = reservationRepository.findById(updateReservation.getId()).get();
			if(updateReservation.getStatus().equals("PAYE")) {
				reservation.setStatePayement(updateReservation.getStatus());
				accountService.addReservationToUserAndTerrain(updateReservation.getId());
				tournoiDtoResponse = reservationRepository.save(reservation);
			}

		} catch (Exception e) {
			throw new CreateReservationException(Long.toString(tournoiDtoResponse.getId()));
		}
		return tournoiDtoResponse;
	}
}
