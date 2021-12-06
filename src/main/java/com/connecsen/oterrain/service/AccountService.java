package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.ListeHeureReserver;
import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.UpdatePasswordUser;
import com.connecsen.oterrain.domaine.UserDoReservation;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.repository.ListerHeureRepository;
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserDoReservationRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.security.JwtTokenUtil;
import com.connecsen.oterrain.utils.Utility;

@Service
@Transactional
public class AccountService implements IAccountService{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	 
	@Autowired
	private UserDetailsService userDetailsService;
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TerrainRepository terrainRepository;
    @Autowired
    private ListerHeureRepository reserverRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserDoReservationRepository userDoReservationRepository;
    @Autowired
    private  JavaMailSender javaMailSender;
     
    @Autowired
	private IReservationService iReservationService;
    
	@Override
	public UserDtoResponse login_up(UserDtoRequest user) {
		String pwdCryp = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(pwdCryp);
		Utilisateur userConverted =Utility.userDtoRequestConvertToUtilisateur(user);
		Utilisateur userSave = userRepository.save(userConverted);
		UserDtoResponse userMap = Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userMap ;
	}
	@Override
	public UserDtoResponse se_connecter(String username,String password) {
		UserDtoResponse userMap = null;
		Utilisateur user = userRepository.findByUsername(username);
			if((user != null)&&(bCryptPasswordEncoder.matches(password, user.getPassword()))){
				userMap = Utility.utilisateurConvertToUserDtoResponse(user);
			}	
		return userMap ;
	}
	@Override
	public long updateResetPasswordToken(String token, String email) {
		Utilisateur user = userRepository.findByEmail(email);
        if (user != null) {
        	user.setResetPasswordToken(token);
        	String pwdCryp = bCryptPasswordEncoder.encode(token);
    		user.setPassword(pwdCryp);
        	userRepository.save(user);
        } else {
           
        }
		return user.getId();
	}

	@Override
	public UserDtoResponse getByResetPasswordToken(String token) {
		Utilisateur user = userRepository.findByResetPasswordToken(token);
		UserDtoResponse userMap = Utility.utilisateurConvertToUserDtoResponse(user);
		return userMap;
	}

	@Override
	public void updatePassword(Utilisateur user, String newPassword) {
        String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);	
	}
	@Override
	public RoleDtoResponse addRole(RoleDtoRequest role) {
		Role roleRequest  =Utility.RoleDtoRequestConvertToRole(role);
		RoleDtoResponse roleDtoResponse  =Utility.roleConvertToRoleDtoResponse(roleRepository.save(roleRequest));
		return roleDtoResponse;
	}

	@Override
	public Utilisateur findUserByUsernameAndEmail(String username,String email) {
		return userRepository.findByUsernameAndEmail(username,email);
	}
	@Override
	public Utilisateur findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	 @Override
    public void sendMail(Mail mail) {
		     SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setFrom(mail.getEmail());
	        msg.setTo(Utility.NOTREEMAIL);
	        msg.setSubject(mail.getSubject());
	        msg.setText(mail.getMessage());

	        javaMailSender.send(msg); 
	    }

	 
	
	@Override
	public void sendMailWithAttachments(Login login,String resetPasswordId) throws MessagingException {
		Utilisateur user = userRepository.findByEmail(login.getEmail());   
		MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            String subject = "Information pour changer le mot de passe";
	        String link ="http://o-terrain.com/#/login";
	        String content = "<p>Bonjour " + user.getNom() + ",</p>"
	                + "<p>Vous aviez reçu cet email pour changer votre mot de passe.</p>"
	                + "<p>Copie ce code : <h3>" + resetPasswordId + "</h3> et inserer comme ancien mot de passe après avoir cliquer sur ce lien:</p>"
	                + "<p>Clique sur le lien  a travers le champ en bleu :</p>"
	                + "<p><a href="+ link +">me connecter à mon compte</a></p>"
	                + "<br>"
	                + "<p>ignore ce message si vous vous souvenez de votre mot de passe, "
	                + "oubien si vous n'avez pas fait cette demande.</p>";
	        helper.setTo(login.getEmail());

	        helper.setSubject(subject);

	       
	        
	        helper.setText(content, true);
	       //helper.addAttachment("terrain.png", new ClassPathResource("terrain.png"));

	        javaMailSender.send(msg);
	    }

	@Override
	public UserDtoResponse createOrUpdateUser(UserDtoRequest user) {
		Utilisateur userRequest =Utility.userDtoRequestConvertToUtilisateur(user);
		Utilisateur userSave = userRepository.save(userRequest);
		UserDtoResponse userMap = Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userMap;
	}

	@Override
	public UserDtoResponse getUserById(Long id) {
		Utilisateur userSave = userRepository.findById(id).get();
		UserDtoResponse userMap = Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userMap;
	}

	@Override
	public List<UserDtoResponse> getAllUsers() {
		List<Utilisateur> utilisateurs =userRepository.findByUserDelete(false);
		List<UserDtoResponse> utilisateurDtoResponses = utilisateurs.stream()
				 .map(utilisateur -> Utility.utilisateurConvertToUserDtoResponse(utilisateur)).collect(Collectors.toList());
		return utilisateurDtoResponses;
		
	}
	@Override
	public boolean deleteUser(Long id) {
		Utilisateur user = userRepository.findById(id).get();
		boolean resultat =false;
		if(user != null)
		{
			userRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	}

	@Override
	public RoleDtoResponse createOrUpdateRole(RoleDtoRequest roleDtoRequest) {
		Role roleRequest =Utility.RoleDtoRequestConvertToRole(roleDtoRequest);
		RoleDtoResponse roleResponse =Utility.roleConvertToRoleDtoResponse(roleRepository.save(roleRequest));
		return roleResponse;
	}

	@Override
	public RoleDtoResponse getRoleById(Long id) {
		RoleDtoResponse roleResponse =Utility.roleConvertToRoleDtoResponse(roleRepository.findById(id).get());
		return roleResponse;
	}

	@Override
	public List<RoleDtoResponse> getAllRoles() {
		List<Role> roles =roleRepository.findAll();
		List<RoleDtoResponse> roleDtoResponses = roles.stream()
				 .map(role -> Utility.roleConvertToRoleDtoResponse(role)).collect(Collectors.toList());
		return roleDtoResponses;

	}
	
	@Override
	public String getToken(String username , String password)
	{
      try {
		authenticate(username,  password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		final UserDetails userDetails = userDetailsService
		.loadUserByUsername(username);		
		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
		
	}
	@Override
	public boolean deleteRole(Long id) {
		RoleDtoResponse role = getRoleById(id);
		boolean resultat =false;
		if(role != null)
		{
			roleRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	}

	
	public  void authenticate(String username, String password) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
		}
		}
	@Override
	public UserDtoResponse addReservationToUser(long idUser, Reservation reservation) {
		Utilisateur userSave = userRepository.findById(idUser).get();
		reservation.setUser(userSave);
		userSave.getReservations().add(reservation);
		UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userRepository.save(userSave));
		return userDtoResponse;
	}
	@Override
	public UserDtoResponse addReservationToUserAndTerrain(long idReservation) {
		 Reservation reservation= iReservationService.getReservationById(idReservation);
		Terrain terrain =terrainRepository.findById(reservation.getIdTerrain()).get();
		
		String[]  date =reservation.getDateReservation().split("/");
		Utilisateur user =userRepository.findById(terrain.getIdUser()).get();
		
		String[] splitted =reservation.getHeure().split(",");
		UserDoReservation userDoReservation = new UserDoReservation();
		userDoReservation.setAdresse(user.getAdresse());
		userDoReservation.setIdUser(user.getId());
		userDoReservation.setNom(user.getNom());
		userDoReservation.setPrenom(user.getPrenom());
		userDoReservation.setTelephone(user.getTelephone());
		UserDoReservation userDoReservationCreate =userDoReservationRepository.save(userDoReservation);
		reservation.setUserDoReservation(userDoReservationCreate);
	
		for (int i = 0; i < splitted.length; i++) {
			ListeHeureReserver reserver = new ListeHeureReserver(
					reservation.getId(),
					Long.parseLong(date[0]),
					Long.parseLong(date[1]),
					splitted[i],null
					);
			ListeHeureReserver reserverSave =reserverRepository.save(reserver);
			terrainRepository.save(terrain);
			terrain.getListeHeureReserver().add(reserverSave);
		}
		terrainRepository.save(terrain);
		Utilisateur userSave=userRepository.save(user);
		UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userDtoResponse;
	}
	@Override
	public Utilisateur updatePasswordUser(UpdatePasswordUser updatePasswordUser) throws Exception {
		    Utilisateur user =userRepository.findById(updatePasswordUser.getIdUser()).get();
		    if((user != null)&&(bCryptPasswordEncoder.matches(updatePasswordUser.getOldPassword(), user.getPassword()))){
		        String encodedPassword = bCryptPasswordEncoder.encode(updatePasswordUser.getNewPassword()); 
		    	user.setPassword(encodedPassword);
			}else {
				throw new Exception("your oldpassword error ");
			}
	        return userRepository.save(user);
	}
	@Override
	public void confirmedMessageAccountCreatedSuccess(Login login) throws MessagingException {
		Utilisateur user =userRepository.findByEmail(login.getEmail());
		MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
         String subject = "Confirmation de creation de compte";
	        String link ="o-terrain.com/#/login";
	        String content = "<p>Bonjour <h3>"+user.getNom()+"</h3>,</p>"
	                + "<p>Vous aviez reçu cet email car vous aviez crée un compte sur notre plateforme.</p>"
	                + "<br>"
	                + "<p>Pour vous connectez utiliser les identifiants ci-dessous.</p>"
	                + "<br>" 
	                + "<p>login : <h3>" +login.getEmail()  + "</h3> </p>"
	                +"<p>mot de passe : <h3>" + login.getPassword()+ "</h3> </p>"
	                 + "<br>"
	                + "<p>Clique sur le lien  a travers le champ en bleu pour accéder à notre plateforme:</p>"
	                + "<p>Veuillez suivre ce lien <a href=\"" + link + "\"></a></p>"
	                + "<br>"
	                + "<p>veuillez ne pas repondre à cet email.</p>";
	        helper.setTo(login.getEmail());

	        helper.setSubject(subject);

	       
	        
	        helper.setText(content, true);
	     //  helper.addAttachment("terrain.png", new ClassPathResource("terrain.png"));

	        javaMailSender.send(msg);
		
	}
	@Override
	public UserDtoResponse addReservationToUserAndTerrainWithoutPaid(long idUser, long idTerrain,
		Reservation reservationDtoRequest) {
		Utilisateur user =userRepository.findById(idUser ).get();
		Terrain terrain =terrainRepository.findById(idTerrain).get();
		 Reservation reservation= iReservationService.createOrUpdateReservation(reservationDtoRequest);
		 reservation.setTerrain(terrain);
		reservation.setUser(user);
		user.getReservations().add(reservation);
		terrain.getReservations().add(reservation);
		terrainRepository.save(terrain);
		Utilisateur userSave=userRepository.save(user);
		UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userDtoResponse;
	}
	@Override
	public UserDtoResponse addReservationToUserAndTerrain(long idUser, long idTerrain,
			Reservation reservationDtoRequest) {
		    Reservation reservation= iReservationService.createOrUpdateReservation(reservationDtoRequest);
			Terrain terrain =terrainRepository.findById(idTerrain).get();
			
			String[]  date =reservation.getDateReservation().split("/");
			Utilisateur user =userRepository.findById(idUser ).get();
			 reservation.setTerrain(terrain);
				reservation.setUser(user);
				user.getReservations().add(reservation);
				terrain.getReservations().add(reservation);
				terrainRepository.save(terrain);
				userRepository.save(user);
			String[] splitted =reservation.getHeure().split(",");
			UserDoReservation userDoReservation = new UserDoReservation();
			userDoReservation.setAdresse(user.getAdresse());
			userDoReservation.setIdUser(user.getId());
			userDoReservation.setNom(user.getNom());
			userDoReservation.setPrenom(user.getPrenom());
			userDoReservation.setTelephone(user.getTelephone());
			UserDoReservation userDoReservationCreate =userDoReservationRepository.save(userDoReservation);
			reservation.setUserDoReservation(userDoReservationCreate);
		
			for (int i = 0; i < splitted.length; i++) {
				ListeHeureReserver reserver = new ListeHeureReserver(
						reservation.getId(),
						Long.parseLong(date[0]),
						Long.parseLong(date[1]),
						splitted[i],terrain
						);
				ListeHeureReserver reserverSave =reserverRepository.save(reserver);
				terrain.getListeHeureReserver().add(reserverSave);
				terrainRepository.save(terrain);
			}
			
			Utilisateur userSave=userRepository.save(user);
			UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userSave);
			return userDtoResponse;
	}
	@Override
	public Utilisateur getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public void initAccount() {
		List<UserDtoResponse> users=this.getAllUsers();
		if(users.size()==0) {
		Role admin=roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("VISITEUR"));
		Role proprietaire=roleRepository.save(new Role("PROPRIETAIRE_TERRAIN"));
		Utilisateur user =new Utilisateur("oterrain.foot@gmail.com", "admin", "admin", "Dakar", "neant", "neant", "2021", false, "oterrain.foot@gmail.com", "774024131", "oteRRain202121@", "neant",admin, null, null, null, null);
		Utilisateur proprietaireCreate =new Utilisateur("ouedraogomahamadi218@gmail.com", "proprietaire", "proprietaire", "Dakar", "neant", "neant", "2021", false, "ouedraogomahamadi218@gmail.com", "774024131", "ouedraogomahamadi218@gmail.com", "neant",proprietaire, null, null, null, null);
		UserDtoRequest userDtoResponse =Utility.utilisateurConvertToUserDtoRequest(user);
		UserDtoRequest proprietaireResponse =Utility.utilisateurConvertToUserDtoRequest(proprietaireCreate);
		this.login_up(proprietaireResponse);
		this.login_up(userDtoResponse);
		}
    	
	}
	
	
	
	}
