package com.connecsen.oterrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.service.IAccountService;

@SpringBootApplication
public class OterrainApplication implements CommandLineRunner{
	@Autowired
	private IAccountService  iAccountService;
	public static void main(String[] args) {
		SpringApplication.run(OterrainApplication.class, args);
	}
    @Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		//Role role = iAccountService.createOrUpdateRole(new Role("USER"));
	//Utilisateur user = iAccountService.login_up( new Utilisateur("PASSER", "user", "fass", "passport", "AAA8888", "1998", "user@user", "99999", "PASSER", iAccountService.getRoleById((long) 1), null, null));
	//System.out.println("USER CREER EST :"+user.getEmail());
	}
	

}
