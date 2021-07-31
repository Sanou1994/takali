package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.security.JwtTokenUtil;
import com.connecsen.oterrain.utils.Utility;

@Service
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
    private RoleRepository roleRepository;
    @Autowired
   private  JavaMailSender javaMailSender;
    
    
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
	public boolean updateResetPasswordToken(String token, String email) {
		Utilisateur user = userRepository.findByEmail(email);
		boolean userFoundResultat = false;
        if (user != null) {
        	user.setResetPasswordToken(token);
        	userRepository.save(user);
        } else {
           
        }
		return userFoundResultat;
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
	        msg.setTo(mail.getRecipient(), mail.getRecipient());

	        msg.setSubject(mail.getSubject());
	        msg.setText(mail.getMessage());

	        javaMailSender.send(msg); 
	    }

	 
	
	@Override
	public void sendMailWithAttachments(Login login,String resetPasswordId) throws MessagingException {
		    MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            String subject = "Information pour changer le mot de passe";
	        String link ="www.google.com";
	        String content = "<p>Salut,</p>"
	                + "<p>Vous aviez reçu cet email pour changer votre mot de passe.</p>"
	                + "<p>Copie ce code : <h3>" + resetPasswordId + "</h3> et insère dans le champ qui va s'afficher après avoir cliquer sur ce lien:</p>"
	                + "<p>Clique sur le lien  a travers le champ en bleu :</p>"
	                + "<p><a href=\"" + link + "\">Changer mon mot de passe</a></p>"
	                + "<br>"
	                + "<p>ignore ce message si vous vous souvenez de votre mot de passe, "
	                + "oubien si vous n'avez pas fait cette demande.</p>";
	        helper.setTo(login.getEmail());

	        helper.setSubject(subject);

	       
	        
	        helper.setText(content, true);
	       helper.addAttachment("logo.jpg", new ClassPathResource("logo.jpg"));

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
		List<Utilisateur> utilisateurs =userRepository.findAll();
		 List<UserDtoResponse> utilisateurDtoResponses = utilisateurs.stream()
				 .map(utilisateur -> Utility.utilisateurConvertToUserDtoResponse(utilisateur)).collect(Collectors.toList());
		return utilisateurDtoResponses;
		
	}
	@Override
	public boolean deleteUser(Long id) {
		UserDtoResponse user = getUserById(id);
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

	
	}