package com.connecsen.oterrain.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.ListeHeureReserver;
import com.connecsen.oterrain.domaine.NombreReservationEtMontant;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.SoldeProprietaire;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.UpdateReservation;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.exception.createexception.CreateReservationException;
import com.connecsen.oterrain.exception.deleteexception.ReservationDeletedException;
import com.connecsen.oterrain.exception.nofoundexception.ReservationNotFoundException;
import com.connecsen.oterrain.repository.ListerHeureRepository;
import com.connecsen.oterrain.repository.ReservationRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.utils.Utility;

@Service
@Transactional
public class ReservationService implements IReservationService {
	@Autowired
	private ListerHeureRepository listeHeureReserverRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private IReservationService iReservationService;
	 @Autowired
	private  JavaMailSender javaMailSender;
	@Override
	public Reservation createOrUpdateReservation(Reservation tournoiDtoRequest) {
		Reservation tournoiDtoResponse = null;
		try {
			tournoiDtoResponse = reservationRepository.save(tournoiDtoRequest);

		} catch (Exception e) {
			throw new CreateReservationException(Long.toString(tournoiDtoRequest.getId()));
		}
		return tournoiDtoResponse;
	}

	@Override
	public Reservation getReservationById(Long id) {
		Reservation tournoiDtoResponse = null;
		try {
			Reservation tournoi = reservationRepository.findById(id).get();
			tournoiDtoResponse = reservationRepository.save(tournoi);

		} catch (Exception e) {
			throw new ReservationNotFoundException(id);
		}
		return tournoiDtoResponse;
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public boolean deleteReservation(Long id) {
		boolean resultat = false;
		try {
			Reservation tournoi = reservationRepository.findById(id).get();
			if (tournoi != null) {
				reservationRepository.deleteById(id);
				resultat = true;
			}
		} catch (Exception e) {
			throw new ReservationDeletedException(id);
		}

		return resultat;

	}

	@Override
	public Reservation updateReservationByStatus(UpdateReservation updateReservation) {
		Reservation tournoiDtoResponse = null;
		try {
			Reservation reservation = reservationRepository.findById(updateReservation.getId()).get();
			reservation.setStatePayement(updateReservation.getStatus());
			tournoiDtoResponse = reservationRepository.save(reservation);
			confirmedMessageReservationPaidSuccess(tournoiDtoResponse);

		} catch (Exception e) {
			throw new CreateReservationException(Long.toString(tournoiDtoResponse.getId()));
		}
		return tournoiDtoResponse;
	}

	@Override
	public void deleteReservationByIdUserAndIdTerrain(Long idUser, Long idTerrain,
			Reservation reservationDtoRequest) {
		List<ListeHeureReserver> heures = new ArrayList<ListeHeureReserver>();
		reservationDtoRequest.setUser(null);
		reservationDtoRequest.setTerrain(null);
		createOrUpdateReservation(reservationDtoRequest);
		Utilisateur user = userRepository.findById(idUser).get();
		Terrain terrain = terrainRepository.findById(idTerrain).get();
		for (int i = 0; i < terrain.getListeHeureReserver().size(); i++) {
			
			if(terrain.getListeHeureReserver().get(i).getIdReservation()==reservationDtoRequest.getId()) {
			
				terrain.getListeHeureReserver().get(i).setTerrain(null);
				terrainRepository.save(terrain);
				listeHeureReserverRepository.deleteById(terrain.getListeHeureReserver().get(i).getId());
			}
		}
		
		terrain.setListeHeureReserver(heures);
		terrain.setReservations(null);
		terrainRepository.save(terrain);
		
		
		  user.setReservations(null);
		  userRepository.save(user);
		  iReservationService.deleteReservation(reservationDtoRequest.getId());
			}

	@Override
	public void confirmedMessageReservationPaidSuccess(Reservation reservation) throws MessagingException {
		 MimeMessage msg = javaMailSender.createMimeMessage();
		Terrain terrain = terrainRepository.findById(reservation.getIdTerrain()).get();
		 Utilisateur user = userRepository.findById(terrain.getIdUser()).get();
		  MimeMessageHelper helper = new MimeMessageHelper(msg, true); 
          String subject ="Confirmation de paiement de reservation";
          String link ="http://o-terrain.com";
		  String content ="<p>Bonjour "+user.getNom()+",</p>" +
		  "<p>Vous aviez reçu cet email car vous aviez fait une reservation de terrain sur notre plateforme.</p>"
		  + "<br>"+"<p>Nom du terrain:<h6>"+reservation.getNomTerrain()+"</h6></p>"
		  +"<p>Adresse du terrain:<h6>"+terrain.getAdresse()+"</h6></p>"+
		  "<p> Date de reservation du terrain :<h6>"+reservation.getDateReservation()+"</h6></p>" 
		  +"<p> somme payée :<h6>"+reservation.getMontantTotal()+"</h6></p>" +
		  "<p>Clique sur le lien  a travers le champ en bleu pour accéder à notre plateforme:</p>"
		  + "<p>Veuillez suivre ce lien <a href="+ link +">se connecter </a></p>" + "<br>" +
		  "<p>veuillez ne pas repondre à cet email.</p>";
		  helper.setTo(user.getEmail());
		  helper.setSubject(subject);
		  
		  helper.setText(content, true); 
		//  helper.addAttachment("terrain.png", new ClassPathResource("terrain.png"));
		  
		  javaMailSender.send(msg);
		 
	}

	@Override
	public NombreReservationEtMontant getNombreReservationEtMontantTotal(String date1, String date2) {
		NombreReservationEtMontant nombreReservationEtMontant= new NombreReservationEtMontant();
		double somme=0.0;
		List<Reservation>reservations=reservationRepository.findBydateReservationBetween(date1,date2);
		for (int i = 0; i < reservations.size(); i++) {
			somme +=reservations.get(i).getMontantTotal();
		}
		nombreReservationEtMontant.setMontantTotal(somme);
		nombreReservationEtMontant.setNombreReservation(reservations.size());
		return nombreReservationEtMontant;
	}

	@Override
	public SoldeProprietaire soldeProprietaire(Long idProprietaire) {
		double montantTotalReservations=0.0;
		double montantTotalDemandeVersement=0.0;
		SoldeProprietaire soldeProprietaire = new SoldeProprietaire();
		Utilisateur proprietaire = userRepository.findById(idProprietaire).get();
		for (int i = 0; i < proprietaire.getReservations().size(); i++) {
			if( proprietaire.getReservations().get(i).getStatePayement().equals("PAYE")) {
				montantTotalReservations +=proprietaire.getReservations().get(i).getMontantTotal();
			}
			
		}
		for (int i = 0; i < proprietaire.getVersements().size(); i++) {
			if( proprietaire.getVersements().get(i).getStatus().equals("VALIDE")) {
				montantTotalReservations +=proprietaire.getVersements().get(i).getMontant();
			}
			
		}
		soldeProprietaire.setMontantTotalDemandeVersement(montantTotalDemandeVersement);
		soldeProprietaire.setMontantTotalReservations(montantTotalReservations);
		soldeProprietaire.setIdProprietaire(idProprietaire);
		
		return soldeProprietaire;
	}

	@Override
	public List<Reservation> getAllReservationsToday() {
		return 	reservationRepository.findBydateReservation(Utility.getToday());
	}
}
