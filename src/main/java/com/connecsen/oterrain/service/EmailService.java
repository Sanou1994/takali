package com.connecsen.oterrain.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.MailSend;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.utils.Utility;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

@Transactional
@Service
public class EmailService implements IEmailService{
	@Value("${app.sendgrid.templateId}")
	private String templateId;
	@Autowired
	private SendGrid sendGrid;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TerrainRepository terrainRepository;
	@Override
	public boolean sendContactEmail(MailSend mailRequest) {
		boolean resultat =false;
		Mail mail = prepareMailContact(mailRequest);
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		try {
			request.setBody(mail.build());
			Response response = sendGrid.api(request);
			if(response != null) {
				resultat =true;
				System.out.println(" response status :"+response.getStatusCode());
				System.out.println(" response body :"+response.getBody());
				System.out.println(" response headers:"+response.getHeaders());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}
	

	public Mail prepareMailContact(MailSend mailRequest) {
		Mail mail = new Mail();
		mail.setSubject(mailRequest.getSubject());
	    mail.addContent(new Content("text/plain", mailRequest.getMessage()));
		Email fromEmail = new Email();
		fromEmail.setEmail(Utility.NOTREEMAIL);
		mail.setFrom(fromEmail);
		Email to = new Email();
		to.setEmail(mailRequest.getEmail());
		Personalization personalization = new Personalization();
		personalization.addTo(to);
		 mail.addPersonalization(personalization);
		return mail;
	}


	@Override
	public boolean sendMailUpdatePassword(Login login, String resetPasswordId) throws MessagingException {
		boolean resultat =false;
		Mail mail = prepareMailUpdatePassword( login,  resetPasswordId);
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		try {
			request.setBody(mail.build());
			Response response = sendGrid.api(request);
			if(response != null) {
				resultat =true;
				System.out.println(" response status :"+response.getStatusCode());
				System.out.println(" response body :"+response.getBody());
				System.out.println(" response headers:"+response.getHeaders());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultat;      
		
	}
	
	public Mail prepareMailUpdatePassword(Login login, String resetPasswordId){
		 Utilisateur user = userRepository.findByEmail(login.getEmail());
	       String subject ="Information pour changer le mot de passe";
	       String link="http://o-terrain.com/#/login"; 
	       String content = "<p>Bonjour " +user.getNom() + ",</p>" +
			  "<p>Vous avez reçu cet email pour changer votre mot de passe.</p>" +
			  "<p>Copiez ce code : <h3>" + resetPasswordId +"</h3> et insésez-le comme le nouveau mot de passe</p>"+
			  "<p>Cliquez sur <a href="+link +"> ce lien </a>en bleu pour vous connectez</p>" +
			  "<p>ignore ce message si vous vous souvenez de votre mot de passe oubien si vous n'avez pas fait cette demande.</p>";
	        Mail mail = new Mail();
			mail.setSubject(subject);
		    mail.addContent(new Content("text/html", content));
			Email fromEmail = new Email();
			fromEmail.setEmail(Utility.NOTREEMAIL);
			mail.setFrom(fromEmail);
			Email to = new Email();
			to.setEmail(login.getEmail());
			Personalization personalization = new Personalization();
			personalization.addTo(to);
			 mail.addPersonalization(personalization);
			 return mail;
	}


	@Override
	public boolean confirmedMessageAccountCreatedSuccess(Login login) throws MessagingException {
		boolean resultat =false;
		Mail mail = prepareMailConfirmedMessageAccountCreatedSuccess( login);
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		try {
			request.setBody(mail.build());
			Response response = sendGrid.api(request);
			if(response != null) {
				resultat =true;
				System.out.println(" response status :"+response.getStatusCode());
				System.out.println(" response body :"+response.getBody());
				System.out.println(" response headers:"+response.getHeaders());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultat;  
		
	}
	public Mail prepareMailConfirmedMessageAccountCreatedSuccess(Login login){
		Utilisateur user =userRepository.findByEmail(login.getEmail());
		 String subject = "Confirmation de création de compte";  
	     String link ="https://o-terrain.com/#/login";
	     String contentString ="<p>Bonjour "+user.getNom()+",</p>"
	                + "<p>Vous avez reçu cet email car vous avez créé un compte sur notre plateforme.</p>"
	                + "<p>Pour vous connectez ,utilisez les identifiants ci-dessous.</p>" 
	                + "<p>login : <h3>" +login.getEmail()  + "</h3> </p>"
	                +"<p>mot de passe : <h3>" + login.getPassword()+ "</h3> </p>"
	                + "<p>Cliquez sur <a href="+ link +"> ce lien </a>en blue pour accéder à notre plateforme:</p>"
	                + "<p>veuillez ne pas repondre à cet email.</p>";
	        Mail mail = new Mail();
			mail.setSubject(subject);
		    mail.addContent(new Content("text/html", contentString));
			Email fromEmail = new Email();
			fromEmail.setEmail(Utility.NOTREEMAIL);
			mail.setFrom(fromEmail);
			Email to = new Email();
			to.setEmail(login.getEmail());
			Personalization personalization = new Personalization();
			personalization.addTo(to);
			 mail.addPersonalization(personalization);
			 return mail;
	}



	@Override
	public boolean confirmedMessageReservationPaidSuccess(Reservation reservation) throws MessagingException {
		boolean resultat =false;
		Mail mail = prepareMailConfirmedMessageReservationPaidSuccess(reservation);
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		try {
			request.setBody(mail.build());
			Response response = sendGrid.api(request);
			if(response != null) {
				resultat =true;
				System.out.println(" response status :"+response.getStatusCode());
				System.out.println(" response body :"+response.getBody());
				System.out.println(" response headers:"+response.getHeaders());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultat;          				  
	}
	public Mail prepareMailConfirmedMessageReservationPaidSuccess(Reservation reservation){
		 Terrain terrain = terrainRepository.findById(reservation.getIdTerrain()).get(); 
         Utilisateur user = userRepository.findById(terrain.getIdUser()).get(); 
		  String subject ="Confirmation de paiement de réservation";
		  String link="http://o-terrain.com";
		  String content ="<p>Bonjour "+user.getNom()+",</p>"+
		  "<p>Vous aviz reçu cet email car vous avez fait une reservation de terrain sur notre plateforme.</p>"
		  +"<p>Nom du terrain:<h6>"+reservation.getNomTerrain()+"</h6></p>"
		  +"<p>Adresse du terrain:<h6>"+terrain.getAdresse()+"</h6></p>"+
		  "<p> Date de reservation du terrain :<h6>"+reservation.getDateReservation()+"</h6></p>"
		  +"<p> somme payée :<h6>"+reservation.getMontantTotal()+"</h6></p>" +
		  "<p>Cliquez sur <a href="+ link +"> ce lien</a>  en blue pour accéder à notre plateforme:</p>"
          + "<p>veuillez ne pas repondre à cet email.</p>";
		  Mail mail = new Mail();
			mail.setSubject(subject);
		    mail.addContent(new Content("text/html", content));
			Email fromEmail = new Email();
			fromEmail.setEmail(Utility.NOTREEMAIL);
			mail.setFrom(fromEmail);
			Email to = new Email();
			to.setEmail(user.getEmail());
			Personalization personalization = new Personalization();
			personalization.addTo(to);
			mail.addPersonalization(personalization);

			 return mail;
	}

}
