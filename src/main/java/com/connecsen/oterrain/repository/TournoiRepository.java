package com.connecsen.oterrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connecsen.oterrain.domaine.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Long> {
  public List<Tournoi> findByTypeTournoi(String typeTournoi);
  public List<Tournoi> findAllByOrderByDateFinDesc();

}
