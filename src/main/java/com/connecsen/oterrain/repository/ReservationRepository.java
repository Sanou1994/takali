package com.connecsen.oterrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connecsen.oterrain.domaine.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
 public List<Reservation> findBydateReservationBetween(String date1,String date2);
 public  List<Reservation> findBydateReservation(String date);
}
