package com.connecsen.oterrain.rest;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.UpdatePasswordUser;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.exception.createexception.CreateException;
import com.connecsen.oterrain.exception.deleteexception.UserDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.UserNotFoundException;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.ITerrainService;
import com.connecsen.oterrain.utils.Utility;

@RestController
public class AccountRestController {
	Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	@Autowired
	private IAccountService accountService;
	@Autowired
	private ITerrainService terrainService;
	@Autowired
	 private UserRepository userRepository;
	@PostMapping(Utility.DO_REGISTER)
	public UserDtoResponse register( @RequestBody UserDtoRequest user) {
		UserDtoResponse userAdd =null;
		try {
			userAdd =accountService.login_up(user);
			logger.info(" new user with role "+userAdd.getRoles().getLibelle() +"created : "+"firstname :"+userAdd.getUsername() +"lastname : "+userAdd.getPrenom());
		} catch (Exception e) {
			throw new CreateException();
		}
		return userAdd;
	}
	@PostMapping(Utility.DO_REGISTER_BY_ADMIN)
	public boolean registerByAmdin( @RequestBody UserDtoRequest user) {
		boolean reponse =false;
		String token = Utility.getTokenResetPassword();
		try {
			user.setPassword(token);
			user.setUsername(user.getEmail());
			UserDtoResponse userAdd =accountService.login_up(user);
			logger.info(" new user with role "+userAdd.getRoles().getLibelle() +"created : "+"firstname :"+userAdd.getUsername() +"lastname : "+userAdd.getPrenom());
			accountService.confirmedMessageAccountCreatedSuccess(new Login(user.getEmail(),token, user.getEmail()));
			reponse =true;
		} catch (Exception e) {
			throw new CreateException();
		}
		return reponse;
	}
	
	@PostMapping(Utility.DO_LOGIN)
	public UserDtoResponse verifiedAccount( @RequestBody Login  login) {
		UserDtoResponse userNull= null ;
		UserDtoResponse user = accountService.se_connecter(login.getUsername(), login.getPassword());
		if(user != null ) {
			user.setMonToken(accountService.getToken(login.getUsername(), login.getPassword()));
			userNull  = user ;
		}else {
		 userNull = new UserDtoResponse();	
		}
		logger.info(" username : "+  userNull.getUsername()+" is role : "+userNull.getRoles().getLibelle() +" connected.......");
		return userNull ;
	}
	@PostMapping(Utility.DO_CONTACTED)
	public void contacteNous(@RequestBody Mail mail) throws MessagingException {	
		logger.info("username : "+mail.getName()+"email: "+mail.getEmail()+" send us message.......");
			accountService.sendMail(mail);
    }
	@PostMapping(Utility.DO_FORGOT_PASSWORD)
	public long sendMail(@RequestBody Login login) throws MessagingException {
		Utilisateur user =accountService.findUserByUsernameAndEmail(login.getUsername(), login.getEmail());
		String token = Utility.getTokenResetPassword();
		long idUser  =0;
		if(user != null) {
			idUser=accountService.updateResetPasswordToken(token,user.getEmail());
			accountService.sendMailWithAttachments(login,token);
		}
		logger.info("username : "+  user.getUsername()+"email: "+user.getEmail()+" forgot his password and changed ");
        return idUser;
    }
	@PostMapping(Utility.DO_UPDATE_PASSWORD_USER)
	public boolean updatePasswordUser(@RequestBody UpdatePasswordUser updatePasswordUser) {
		boolean reponse = false;
		try {
			 Utilisateur user =accountService.updatePasswordUser(updatePasswordUser);
			reponse = true;
			logger.info("username : "+  user.getUsername()+"email: "+user.getEmail()+" update password from "+updatePasswordUser.getOldPassword()+" to  "+updatePasswordUser.getNewPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return reponse;
    }
	@PostMapping(Utility.DO_UPDATE_PASSWORD)
	public String updatePassword(HttpServletRequest request) throws MessagingException {
		 String token = request.getParameter("token");
		 String password = request.getParameter("password");
		 UserDtoResponse user =accountService.getByResetPasswordToken(token);
		String resultat  ="echec";
		if(user != null) {
			accountService.updatePassword(Utility.userDtoResponseConvertToUtilisateur(user), password);
			resultat ="sucsess";
		}
		logger.info("username : "+  user.getUsername()+"email: "+user.getEmail()+" tried to change your password with "+resultat);
        return resultat;
    }
	@PostMapping(Utility.ADD_USER)
	public UserDtoResponse getAddOrUpdateUser( @RequestBody UserDtoRequest user){
		UserDtoResponse resultatCreation = accountService.createOrUpdateUser(user);
		return resultatCreation;
    }

    @PostMapping(Utility.ADD_RESERVATION_TO_USER_AND_TERRAIN)
	public TerrainDtoResponse getAddReservationUserAndTerrain( @PathVariable(value = "idTerrain") Long idTerrain, @PathVariable(value = "idUser") Long idUser, @RequestBody Reservation reservationDtoRequest){
		TerrainDtoResponse terrainBefore =terrainService.getTerrainById(idTerrain);
    	accountService.addReservationToUserAndTerrain(idUser,idTerrain,reservationDtoRequest);
		UserDtoResponse userGot =accountService.getUserById(idUser);
		TerrainDtoResponse terrainAfter =terrainService.getTerrainById(idTerrain);
		String succesResultat ="echec";
		if(terrainBefore.getReservations().size() !=terrainAfter.getReservations().size()) {
			succesResultat = "success";
		}
		logger.info("username : "+  userGot.getUsername()+"with role : "+userGot.getRoles().getLibelle()+" tried to add reservation on bascket of terrain "+
				terrainAfter.getNom()+" with  "+succesResultat);
		return terrainAfter ;
    }

	@PostMapping(Utility.ADD_RESERVATION_TO_USER)
	public UserDtoResponse addReservationToUser(@PathVariable(value = "id") Long idUser, @RequestBody Reservation reservation){
		UserDtoResponse userGot =accountService.getUserById(idUser);
		UserDtoResponse resultatCreation = accountService.addReservationToUser(idUser, reservation);
		boolean succesResultat =false;
		if(resultatCreation.getReservations().size() !=userGot.getReservations().size()) {
			succesResultat = true;
		}
		logger.info("username : "+  resultatCreation.getUsername()+"with role : "+resultatCreation.getRoles().getLibelle()+" tried to add reservation on bascket with "+succesResultat);
		return resultatCreation ;
    }
	@PostMapping(Utility.UPDATE_USER)
	public UserDtoResponse getUpdateUser( @RequestBody UserDtoRequest user){
		UserDtoResponse userUpdate = null;
		try {
			UserDtoResponse userGot =accountService.getUserById(user.getId());
			 userUpdate = accountService.createOrUpdateUser(user);
			logger.info("username : "+  userGot.getUsername()+"with role : "+userGot.getRoles().getLibelle()+" tried to update information and old information : "+userGot.toString());
			logger.info("username : "+  userUpdate.getUsername()+"with role : "+userUpdate.getRoles().getLibelle()+" had tried to update information and new information : "+userUpdate.toString());
				
		} catch (Exception e) {
			throw new CreateException();
		}
		return userUpdate;
    }
	@GetMapping(Utility.GET_ALL_USERS)
	public List<Utilisateur> getAllUser(){
		return userRepository.findAll();
    }
	@GetMapping(Utility.GET_USER_BY_ID)
	public UserDtoResponse getUserById(@PathVariable(value = "id") Long userId){
		UserDtoResponse userUpdate = null;
		try {
			userUpdate =accountService.getUserById(userId);
		} catch (Exception e) {
			throw new UserNotFoundException(Long.toString(userId));
		}
		return userUpdate ;
    }
	@GetMapping(Utility.DELETE_USER_BY_ID)
	public boolean getDeleteUser(@PathVariable(value = "id") Long userId){
		 boolean resultat =false;
		try {
			UserDtoResponse userGot =accountService.getUserById(userId);
	       resultat = accountService.deleteUser(userId);
			logger.info("username : "+  userGot.getUsername()+"with role : "+userGot.getRoles().getLibelle()+" was deleted  with  : "+resultat);
	
		} catch (Exception e) {
			throw new UserDeletedException(userId);
		}
				return resultat;
    }
	@PostMapping(Utility.ADD_ROLE)
	public RoleDtoResponse getAddOrUpdateRole( @RequestBody RoleDtoRequest role){
		return accountService.createOrUpdateRole(role);
    }
	@PostMapping(Utility.UPDATE_ROLE)
	public RoleDtoResponse getUpdateRole( @RequestBody RoleDtoRequest role){
		return accountService.createOrUpdateRole(role);
    }
	@GetMapping(Utility.GET_ALL_ROLES)
	public List<RoleDtoResponse> getAllRole(){
		return accountService.getAllRoles();
    }
	@GetMapping(Utility.GET_ROLE_BY_ID)
	public RoleDtoResponse getRoleById(@PathVariable(value = "id") Long roleId){
		return accountService.getRoleById(roleId);
    }
	@GetMapping(Utility.DELETE_ROLE_BY_ID)
	public boolean getDeleteRole(@PathVariable(value = "id") Long roleId){
		return accountService.deleteRole(roleId);
    }
	
}
