package com.connecsen.oterrain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.UpdateReservation;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.exception.createexception.CreateReservationException;
import com.connecsen.oterrain.exception.deleteexception.ReservationDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.ReservationNotFoundException;
import com.connecsen.oterrain.repository.ReservationRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;
@Service
public class ReservationService implements IReservationService{
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private IReservationService iReservationService;
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
				reservation.setStatePayement(updateReservation.getStatus());
				tournoiDtoResponse = reservationRepository.save(reservation);

		} catch (Exception e) {
			throw new CreateReservationException(Long.toString(tournoiDtoResponse.getId()));
		}
		return tournoiDtoResponse;
	}

	@Override
	public boolean deleteReservationByIdUserAndIdTerrain(Long idUser, Long idTerrain,
			Reservation reservationDtoRequest) {
		List<Reservation> reservationUsers = new ArrayList<Reservation>();
		List<Reservation> reservationTerrains = new ArrayList<Reservation>();
        boolean resultat =false;
		Utilisateur user = userRepository.findById(idUser).get();
		Terrain terrain = terrainRepository.findById(idTerrain).get();
		for (int i = 0; i < user.getReservations().size(); i++) {
			if(user.getReservations().get(i).getId()!=reservationDtoRequest.getId()) {
				Reservation reservation =reservationRepository.save(user.getReservations().get(i));
				reservationUsers.add(reservation);
				iReservationService.deleteReservation(user.getReservations().get(i).getId());
				resultat=true;
			}
		}
		System.out.println(" taille nouveau tablo :"+reservationUsers.size());
		user.setReservations(reservationUsers);
		System.out.println("  nouveau user taille:"+user.getReservations().size());
		userRepository.save(user);
		System.out.println("  nouveau user taille apres :"+user.getReservations().size());
		terrain.setReservations(reservationTerrains);
		terrainRepository.save(terrain);
		
		
		
		
		return resultat;
	}
}
