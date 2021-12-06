package com.connecsen.oterrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connecsen.oterrain.domaine.Versement;

public interface VersementRepository extends JpaRepository<Versement,Long>{
public List<Versement> findByIdUser(Long idUser);
}
