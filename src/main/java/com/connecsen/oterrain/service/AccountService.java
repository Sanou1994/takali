package com.connecsen.oterrain.service;

import java.util.List;

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
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.security.JwtTokenUtil;

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
	public Utilisateur login_up(Utilisateur user) {
		String pwdCryp = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(pwdCryp);
		Utilisateur userSave = userRepository.save(user);
		return userSave;
	}
	@Override
	public Utilisateur se_connecter(String username,String password) {
		Utilisateur user = userRepository.findByUsername(username);
		boolean resultat = bCryptPasswordEncoder.matches(password, user.getPassword());
		return (resultat) ? user : null;
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
	public Utilisateur getByResetPasswordToken(String token) {
		return userRepository.findByResetPasswordToken(token);
	}

	@Override
	public void updatePassword(Utilisateur user, String newPassword) {
        String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);	
	}
	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
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
	public Utilisateur createOrUpdateUser(Utilisateur user) {
		return userRepository.save(user);
	}

	@Override
	public Utilisateur getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<Utilisateur> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUser(Long id) {
		Utilisateur user = getUserById(id);
		boolean resultat =false;
		if(user != null)
		{
			userRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	}

	@Override
	public Role createOrUpdateRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
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
		Role role = getRoleById(id);
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
