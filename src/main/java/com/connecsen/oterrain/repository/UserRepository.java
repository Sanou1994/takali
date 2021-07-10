package com.connecsen.oterrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connecsen.oterrain.domaine.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur,Long>{
    public Utilisateur findByUsername(String username);
    public Utilisateur findByUsernameAndEmail(String username,String email);
    public Utilisateur findByUsernameAndPassword(String username,String password);
}
 