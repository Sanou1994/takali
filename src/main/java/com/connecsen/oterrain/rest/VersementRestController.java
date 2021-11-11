package com.connecsen.oterrain.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.dto.request.VersementDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.VersementDtoResponse;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.IVersementService;
import com.connecsen.oterrain.utils.Utility;
@RestController
public class VersementRestController {
	Logger logger = LoggerFactory.getLogger(VersementRestController.class);
	@Autowired
	private IVersementService iVersementService;
	@Autowired
	private IAccountService accountService;
	
	@PostMapping(Utility.ADD_VERSEMENT)
	public VersementDtoResponse ajouterVersement( @RequestBody VersementDtoRequest versement) {
		VersementDtoResponse versementAdd =iVersementService.createOrUpdateVersement(versement);
		return versementAdd;
	}
	@PostMapping(Utility.UPDATE_VERSEMENT)
	public VersementDtoResponse getUpdateVersement( @RequestBody VersementDtoRequest versement){
		return iVersementService.createOrUpdateVersement(versement);
    }
	@GetMapping(Utility.GET_ALL_VERSEMENTS)
	public List<VersementDtoResponse> getAllVersement(){
		return iVersementService.getAllVersements();
    }
	@GetMapping(Utility.GET_VERSEMENT_BY_ID)
	public VersementDtoResponse getVersementById(@PathVariable(value = "id") Long userId){
		return iVersementService.getVersementById(userId);
    }
	@GetMapping(Utility.DELETE_VERSEMENT_BY_ID)
	public boolean getDeleteVersement(@PathVariable(value = "id") Long userId){
		return iVersementService.deleteVersement(userId);
    }
	 @PostMapping(Utility.ADD_VERSEMENT_TO_USER)
		public VersementDtoResponse getAddVersementToUser( @PathVariable(value = "idUser") Long idUser, @RequestBody VersementDtoRequest transactionDtoRequest){
		 UserDtoResponse userBefore =accountService.getUserById(idUser);
		 VersementDtoResponse resultatVersement = iVersementService.addVersementToUser(idUser,transactionDtoRequest);
		UserDtoResponse userGot =accountService.getUserById(idUser);
		String succesResultat ="echec";
			if(userBefore.getVersements().size() !=userGot.getVersements().size()) {
				succesResultat = "success";
			}
	logger.info("username : "+  userGot.getUsername()+"with role : "+userGot.getRoles().getLibelle()+" tried to do transaction of versement :"+
					" with  "+succesResultat);
			return resultatVersement ;
	    }
	 
}
