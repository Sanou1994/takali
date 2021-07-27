package com.connecsen.oterrain.rest;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.utils.Utility;

@RestController
public class AccountRestController {

	@Autowired
	private IAccountService accountService;

	@PostMapping(Utility.DO_REGISTER)
	public UserDtoResponse register( @RequestBody UserDtoRequest user) {
		UserDtoResponse userAdd =accountService.login_up(user);
		return userAdd;
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
		return userNull ;
	}
	
	@PostMapping(Utility.DO_FORGOT_PASSWORD)
	public boolean sendMail(@RequestBody Login login) throws MessagingException {
		Utilisateur user =accountService.findUserByUsernameAndEmail(login.getUsername(), login.getEmail());
		String token = Utility.getTokenResetPassword();
		boolean resultat  =false;
		if(user != null) {
			accountService.updateResetPasswordToken(token,user.getEmail());
			accountService.sendMailWithAttachments(login,token);
			resultat =true;
		}
        return resultat;
    }
	
	@PutMapping(Utility.DO_UPDATE_PASSWORD)
	public boolean updatePassword(HttpServletRequest request) throws MessagingException {
		 String token = request.getParameter("token");
		 String password = request.getParameter("password");
		 UserDtoResponse user =accountService.getByResetPasswordToken(token);
		boolean resultat  =false;
		if(user != null) {
			accountService.updatePassword(Utility.userDtoResponseConvertToUtilisateur(user), password);
			resultat =true;
		}
        return resultat;
    }
	@PostMapping(Utility.ADD_USER)
	public UserDtoResponse getAddOrUpdateUser( @RequestBody UserDtoRequest user){
		return accountService.createOrUpdateUser(user);
    }
	@PutMapping(Utility.UPDATE_USER)
	public UserDtoResponse getUpdateUser( @RequestBody UserDtoRequest user){
		return accountService.createOrUpdateUser(user);
    }
	@GetMapping(Utility.GET_ALL_USERS)
	public List<UserDtoResponse> getAllUser(){
		return accountService.getAllUsers();
    }
	@GetMapping(Utility.GET_USER_BY_ID)
	public UserDtoResponse getUserById(@PathVariable(value = "id") Long userId){
		return accountService.getUserById(userId);
    }
	@DeleteMapping(Utility.DELETE_USER_BY_ID)
	public boolean getDeleteUser(@PathVariable(value = "id") Long userId){
		return accountService.deleteUser(userId);
    }
	@PostMapping(Utility.ADD_ROLE)
	public RoleDtoResponse getAddOrUpdateRole( @RequestBody RoleDtoRequest role){
		return accountService.createOrUpdateRole(role);
    }
	@PutMapping(Utility.UPDATE_ROLE)
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
	@DeleteMapping(Utility.DELETE_ROLE_BY_ID)
	public boolean getDeleteRole(@PathVariable(value = "id") Long roleId){
		return accountService.deleteRole(roleId);
    }
	
}
