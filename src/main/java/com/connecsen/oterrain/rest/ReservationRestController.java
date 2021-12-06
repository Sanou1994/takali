package com.connecsen.oterrain.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.NombreReservationEtMontant;
import com.connecsen.oterrain.domaine.NombreReservationEtMontantObjet;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.SoldeProprietaire;
import com.connecsen.oterrain.domaine.UpdateReservation;
import com.connecsen.oterrain.service.IReservationService;
import com.connecsen.oterrain.utils.Utility;
@RestController
public class ReservationRestController {
	
	@Autowired
	private IReservationService iReservationService;
	
	@PostMapping(Utility.ADD_RESERVATION)
	public Reservation ajouterTournoi( @RequestBody Reservation tournoi) {
		Reservation tournoiAdd =iReservationService.createOrUpdateReservation(tournoi);
		return tournoiAdd;
	}
	@PostMapping(Utility.UPDATE_RESERVATION)
	public Reservation getUpdateUser( @RequestBody Reservation user){
		return iReservationService.createOrUpdateReservation(user);
    }
	@PostMapping(Utility.UPDATE_RESERVATION_BY_STATUS)
	public Reservation getUpdateReservation( @RequestBody UpdateReservation user){
		return iReservationService.updateReservationByStatus(user);
    }
	
	@GetMapping(Utility.GET_ALL_RESERVATIONS)
	public List<Reservation> getAllTournoi(){
		return iReservationService.getAllReservations();
    }
	@GetMapping(Utility.GET_RESERVATION_BY_ID)
	public Reservation getTournoiById(@PathVariable(value = "id") Long userId){
		return iReservationService.getReservationById(userId);
    }
	@GetMapping(Utility.GET_SOLDE_RESERVATION_BY_PROPRIETAIRE)
	public SoldeProprietaire getSoldeByProprietaire(@PathVariable(value = "idProprietaire") Long idProprietaire){
		return iReservationService.soldeProprietaire(idProprietaire);
    }
	@GetMapping(Utility.DELETE_RESERVATION_BY_ID)
	public boolean getDeleteTournoi(@PathVariable(value = "id") Long userId){
		return iReservationService.deleteReservation(userId);
    }
	
	@PostMapping(Utility.GET_ALL_RESERVATIONS_BETWEEN_DATE)
	public NombreReservationEtMontant getAllReservationsBetweenDate( @RequestBody NombreReservationEtMontantObjet nombreReservationEtMontantObjet){
		return iReservationService.getNombreReservationEtMontantTotal(nombreReservationEtMontantObjet.getDate1(),nombreReservationEtMontantObjet.getDate2());
    }
	
}
