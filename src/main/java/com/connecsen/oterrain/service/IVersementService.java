package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.dto.request.VersementDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.VersementDtoResponse;

public interface IVersementService {
	//GESTION TRANSACTIONS
	  public VersementDtoResponse createOrUpdateVersement( VersementDtoRequest versementDtoRequest);
	  public  VersementDtoResponse getVersementById(Long id);
	  public List<VersementDtoResponse> getAllVersements();
	  public boolean deleteVersement(Long id);
	  public List<VersementDtoResponse> getVersementByUser(long idUser);
	  public VersementDtoResponse addVersementToUser( long idUser,VersementDtoRequest transactionDtoRequest);

}
