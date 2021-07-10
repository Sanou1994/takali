package com.connecsen.oterrain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.Mail;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.UserRepository;

@Service
public class AccountService implements IAccountService{
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private final JavaMailSender javaMailSender;
    
    public AccountService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
	@Override
	public Utilisateur login_up(Utilisateur user) {
		String pwdCryp = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(pwdCryp);
		Utilisateur userSave = userRepository.save(user);
		return userSave;
	}
	@Override
	public Utilisateur login_in(String username,String password) {
		String pwdCryp = bCryptPasswordEncoder.encode(password);
		Utilisateur user = userRepository.findByUsernameAndPassword(username, pwdCryp);
		return user;
	}

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String libelle, String username) {
		Role role =roleRepository.findByLibelle(libelle);
		Utilisateur userFound = userRepository.findByUsername(username);
		userFound.getRoles().add(role);
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
	public void sendMailWithAttachments(Login login) throws MessagingException {
	        MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

	        helper.setTo(login.getEmail());

	        helper.setSubject("Information sur changer mot de passe");

	        helper.setText("<html><body><div class=\"container\">\r\n" + 
	        		"			<h3>Information changer mot de passe</h3><br/>\r\n" + 
	        		"			<span>Cliquer sur ce lien ci-dessous pour changer votre de passe</span><br/>\r\n" + 
	        		"			<span><a href=\"http://www.google.com\">X88X8E8Z88R8F8Z88288J?NF88E88A8Z8ER8G8</a></span>\r\n" + 
	        		"		 </div></body></html>", true);

	       helper.addAttachment("logo.jpg", new ClassPathResource("logo.jpg"));

	        javaMailSender.send(msg);
	    }
	}

