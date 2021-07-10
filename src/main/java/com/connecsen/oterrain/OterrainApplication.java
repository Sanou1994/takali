package com.connecsen.oterrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.service.AccountService;

@SpringBootApplication
public class OterrainApplication implements CommandLineRunner{
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(OterrainApplication.class, args);
	}
    @Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		Login login = new Login("SANOU","1234","sanouarouna90@gmail.com");
		accountService.sendMailWithAttachments(login);
		System.out.println("sending message.....................");
		
}
}
