package com.connecsen.oterrain.service;

import javax.mail.MessagingException;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Utilisateur;

public interface IAccountService {
      // SERVICE UTILISATEUR
	  public Utilisateur login_in(String username,String password);
	  public Utilisateur login_up(Utilisateur user);
	  public Role addRole(Role role);
	  public void addRoleToUser(String libelle ,String username);
	  public Utilisateur findUserByUsername(String username);
	  public Utilisateur findUserByUsernameAndEmail(String username,String email);
	  public void sendMail(Mail mail);
      public void sendMailWithAttachments(Login login) throws MessagingException;
}
