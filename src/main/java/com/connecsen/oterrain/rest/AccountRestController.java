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
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.utils.Utility;

@RestController
public class AccountRestController {

	@Autowired
	private IAccountService accountService;
	
	@PostMapping(Utility.DO_REGISTER)
	public Utilisateur register( @RequestBody Utilisateur user) {
		Utilisateur userAdd =accountService.login_up(user);
		return userAdd;
	}
	
	@PostMapping(Utility.DO_LOGIN)
	public Utilisateur verifiedAccount( @RequestBody Login  login) {
		Utilisateur user = accountService.se_connecter(login.getUsername(), login.getPassword());
		user.setMonToken(accountService.getToken(login.getUsername(), login.getPassword()));
		return user;
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
		 Utilisateur user =accountService.getByResetPasswordToken(token);
		boolean resultat  =false;
		if(user != null) {
			accountService.updatePassword(user, password);
			resultat =true;
		}
        return resultat;
    }
	@PostMapping(Utility.ADD_USER)
	public Utilisateur getAddOrUpdateUser( @RequestBody Utilisateur user){
		return accountService.createOrUpdateUser(user);
    }
	@PutMapping(Utility.UPDATE_USER)
	public Utilisateur getUpdateUser( @RequestBody Utilisateur user){
		return accountService.createOrUpdateUser(user);
    }
	@GetMapping(Utility.GET_ALL_USERS)
	public List<Utilisateur> getAllUser(){
		return accountService.getAllUsers();
    }
	@GetMapping(Utility.GET_USER_BY_ID)
	public Utilisateur getUserById(@PathVariable(value = "id") Long userId){
		return accountService.getUserById(userId);
    }
	@DeleteMapping(Utility.DELETE_USER_BY_ID)
	public boolean getDeleteUser(@PathVariable(value = "id") Long userId){
		return accountService.deleteUser(userId);
    }
	@PostMapping(Utility.ADD_ROLE)
	public Role getAddOrUpdateRole( @RequestBody Role role){
		return accountService.createOrUpdateRole(role);
    }
	@PutMapping(Utility.UPDATE_ROLE)
	public Role getUpdateRole( @RequestBody Role role){
		return accountService.createOrUpdateRole(role);
    }
	@GetMapping(Utility.GET_ALL_ROLES)
	public List<Role> getAllRole(){
		return accountService.getAllRoles();
    }
	@GetMapping(Utility.GET_ROLE_BY_ID)
	public Role getRoleById(@PathVariable(value = "id") Long roleId){
		return accountService.getRoleById(roleId);
    }
	@DeleteMapping(Utility.DELETE_ROLE_BY_ID)
	public boolean getDeleteRole(@PathVariable(value = "id") Long roleId){
		return accountService.deleteRole(roleId);
    }
	
}
