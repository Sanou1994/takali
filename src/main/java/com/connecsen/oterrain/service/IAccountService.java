package com.connecsen.oterrain.service;

import java.util.List;

import javax.mail.MessagingException;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Utilisateur;

public interface IAccountService {
      // SERVICE UTILISATEUR
	
	         //GESTION ROLE
	  public Role createOrUpdateRole(Role role);
	  public Role addRole(Role role);
	  public Role getRoleById(Long id);
	  public List<Role> getAllRoles();
	  public boolean deleteRole(Long id);
	 
	         //GESTION USER
	  public String getToken(String username , String password);
	  public Utilisateur createOrUpdateUser(Utilisateur user);
	  public Utilisateur getUserById(Long id);
	  public List<Utilisateur> getAllUsers();
	  public boolean deleteUser(Long id); 
	  public Utilisateur se_connecter(String username,String password);
	  public Utilisateur login_up(Utilisateur user);
	  public Utilisateur findUserByUsername(String username);
	  public Utilisateur findUserByUsernameAndEmail(String username,String email);
	  public void sendMail(Mail mail);
      public void sendMailWithAttachments(Login login,String resetPasswordId) throws MessagingException;
      public boolean updateResetPasswordToken(String token, String email);
      public Utilisateur getByResetPasswordToken(String token);
      public void updatePassword(Utilisateur user, String newPassword);

}
