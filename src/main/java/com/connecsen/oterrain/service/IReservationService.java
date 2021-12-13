package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.NombreReservationEtMontant;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.SoldeProprietaire;
import com.connecsen.oterrain.domaine.UpdateReservation;

public interface IReservationService {
	 //GESTION EQUIPES
	  public Reservation createOrUpdateReservation(Reservation reservationDtoRequest);
	  public Reservation updateReservationByStatus(UpdateReservation updateReservation);
	  public  Reservation getReservationById(Long id);
	  public List<Reservation> getAllReservations();
	  public List<Reservation> getAllReservationsToday();
	  public void deleteReservationByIdUserAndIdTerrain(Long idUser,Long idTerrain,Reservation reservationDtoRequest);
	  public boolean deleteReservation(Long id); 
      public NombreReservationEtMontant getNombreReservationEtMontantTotal(String date1,String date2);
      public SoldeProprietaire soldeProprietaire(Long idProprietaire);
}
