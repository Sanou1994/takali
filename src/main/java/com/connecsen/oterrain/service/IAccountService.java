package com.connecsen.oterrain.service;

import java.util.List;

import javax.mail.MessagingException;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.UpdatePasswordUser;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;

public interface IAccountService {
      // SERVICE UTILISATEUR
	
	         //GESTION ROLE
	  public RoleDtoResponse createOrUpdateRole(RoleDtoRequest role);
	  public RoleDtoResponse addRole(RoleDtoRequest role);
	  public RoleDtoResponse getRoleById(Long id);
	  public List<RoleDtoResponse> getAllRoles();
	  public boolean deleteRole(Long id);
	 
	         //GESTION USER
	  public void initAccount();
	  public String getToken(String username , String password);
	  public UserDtoResponse addReservationToUserAndTerrain(long idReservation);
	  public UserDtoResponse addReservationToUserAndTerrain(long idUser,long idTerrain,Reservation reservationDtoRequest);
	  public UserDtoResponse addReservationToUserAndTerrainWithoutPaid(long idUser,long idTerrain,Reservation reservationDtoRequest);
	  public UserDtoResponse createOrUpdateUser(UserDtoRequest user);
	  public UserDtoResponse getUserById(Long id);
	  public List<UserDtoResponse> getAllUsers();
	  public boolean deleteUser(Long id); 
	  public UserDtoResponse se_connecter(String username,String password);
	  public UserDtoResponse login_up(UserDtoRequest user);
	  public Utilisateur findUserByUsername(String username);
	  public Utilisateur findUserByUsernameAndEmail(String username,String email);
	  public Utilisateur getUserByEmail(String email);
	  public void sendMail(Mail mail);
      public void confirmedMessageAccountCreatedSuccess(Login login) throws MessagingException;
      public void sendMailWithAttachments(Login login,String resetPasswordId) throws MessagingException;
      public long updateResetPasswordToken(String token, String email);
      public UserDtoResponse getByResetPasswordToken(String token);
      public void updatePassword(Utilisateur user, String newPassword);
      public Utilisateur updatePasswordUser(UpdatePasswordUser updatePasswordUser ) throws Exception;
      public UserDtoResponse addReservationToUser(long idUser,Reservation reservation);
}
