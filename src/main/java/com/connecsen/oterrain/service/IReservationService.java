package com.connecsen.oterrain.service;

import java.util.List;

import javax.mail.MessagingException;

import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.UpdateReservation;

public interface IReservationService {
	 //GESTION EQUIPES
	  public Reservation createOrUpdateReservation(Reservation reservationDtoRequest);
	  public Reservation updateReservationByStatus(UpdateReservation updateReservation);
	  public  Reservation getReservationById(Long id);
	  public List<Reservation> getAllReservations();
	  public void deleteReservationByIdUserAndIdTerrain(Long idUser,Long idTerrain,Reservation reservationDtoRequest);
	  public boolean deleteReservation(Long id); 
      public void confirmedMessageReservationPaidSuccess(Reservation reservation) throws MessagingException;

}
