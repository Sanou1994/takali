package com.connecsen.oterrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connecsen.oterrain.domaine.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{
	
}