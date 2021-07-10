package com.connecsen.oterrain.rest;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.service.AccountService;

@RestController
@RequestMapping("/user")
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public Utilisateur register( @RequestBody Utilisateur user) {
		Utilisateur userAdd =accountService.login_up(user);
		accountService.addRoleToUser("USER", userAdd.getUsername());
		return userAdd;
	}
	
	@PostMapping("/login")
	public Utilisateur verifiedAccount( @RequestBody Login  login) {
		Utilisateur user = accountService.login_in(login.getUsername(), login.getPassword());
		return user;
	}
	
	@PostMapping("/forgot")
	public boolean sendMail(@RequestBody Login login) throws MessagingException {
		Utilisateur user =accountService.findUserByUsernameAndEmail(login.getUsername(), login.getEmail());
		boolean resultat  =false;
		if(user != null) {
			accountService.sendMailWithAttachments(login);
			resultat =true;
		}
        return resultat;
    }
	
}
