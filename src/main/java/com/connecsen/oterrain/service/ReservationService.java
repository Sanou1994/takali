package com.connecsen.oterrain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.ListeHeureReserver;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.UpdateReservation;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.exception.createexception.CreateReservationException;
import com.connecsen.oterrain.exception.deleteexception.ReservationDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.ReservationNotFoundException;
import com.connecsen.oterrain.repository.ListerHeureRepository;
import com.connecsen.oterrain.repository.ReservationRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;

@Service
public class ReservationService implements IReservationService {
	@Autowired
	private ListerHeureRepository listeHeureReserverRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private IReservationService iReservationService;

	@Override
	public Reservation createOrUpdateReservation(Reservation tournoiDtoRequest) {
		Reservation tournoiDtoResponse = null;
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
			if (tournoi != null) {
				reservationRepository.deleteById(id);
				resultat = true;
			}
		} catch (Exception e) {
			throw new ReservationDeletedException(id);
		}

		return resultat;

	}

	@Override
	public Reservation updateReservationByStatus(UpdateReservation updateReservation) {
		Reservation tournoiDtoResponse = null;
		try {
			Reservation reservation = reservationRepository.findById(updateReservation.getId()).get();
			reservation.setStatePayement(updateReservation.getStatus());
			tournoiDtoResponse = reservationRepository.save(reservation);

		} catch (Exception e) {
			throw new CreateReservationException(Long.toString(tournoiDtoResponse.getId()));
		}
		return tournoiDtoResponse;
	}

	@Override
	public void deleteReservationByIdUserAndIdTerrain(Long idUser, Long idTerrain,
			Reservation reservationDtoRequest) {
		List<ListeHeureReserver> heures = new ArrayList<ListeHeureReserver>();
		reservationDtoRequest.setUser(null);
		reservationDtoRequest.setTerrain(null);
		createOrUpdateReservation(reservationDtoRequest);
		Utilisateur user = userRepository.findById(idUser).get();
		Terrain terrain = terrainRepository.findById(idTerrain).get();
		for (int i = 0; i < terrain.getListeHeureReserver().size(); i++) {
			
			if(terrain.getListeHeureReserver().get(i).getIdReservation()==reservationDtoRequest.getId()) {
			
				terrain.getListeHeureReserver().get(i).setTerrain(null);
				terrainRepository.save(terrain);
				listeHeureReserverRepository.deleteById(terrain.getListeHeureReserver().get(i).getId());
			}
		}
		
		terrain.setListeHeureReserver(heures);
		terrain.setReservations(null);
		terrainRepository.save(terrain);
		
		
		  user.setReservations(null);
		  userRepository.save(user);
		  iReservationService.deleteReservation(reservationDtoRequest.getId());
			}
}
