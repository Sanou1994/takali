package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.Indisponibilite;
import com.connecsen.oterrain.domaine.Terrain;

public interface IIndisponibiliteService {
	//GESTION ChoosePeriodicDay
	  public Indisponibilite createIndisponibilite( Indisponibilite choosePeriodicDay);
	  public Indisponibilite updateIndisponibilite( Indisponibilite choosePeriodicDay);
	  public  Indisponibilite getIndisponibiliteById(Long id);
	  public List<Indisponibilite> getAllIndisponibilites();
	  public void deleteIndisponibiliteDay(Long id); 
	  public  Terrain addIndisponibiliteToTerrain(Long idTerrain,Indisponibilite choosePeriodicDay);
}
