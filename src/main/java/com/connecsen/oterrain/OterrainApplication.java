package com.connecsen.oterrain;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.sun.mail.imap.Utility;
//import com.connecsen.oterrain.service.IMatchService;
//import com.connecsen.oterrain.service.IReservationService;
@Configuration
@SpringBootApplication
public class OterrainApplication implements CommandLineRunner {
	
	// @Autowired(required=true)
	// IMatchService iMatchService;	

	public static void main(String[] args) {
		SpringApplication.run(OterrainApplication.class, args);
	}

	/*
	 * //Connexon à la base via le plugin postgres payant
	 * 
	 * @Bean
	 * 
	 * @Order(0) public BasicDataSource dataSource() throws URISyntaxException { URI
	 * dbUri = new URI(System.getenv("DATABASE_URL"));
	 * 
	 * String username = dbUri.getUserInfo().split(":")[0]; String password =
	 * dbUri.getUserInfo().split(":")[1]; String dbUrl = "jdbc:postgresql://" +
	 * dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() +
	 * "?sslmode=require";
	 * 
	 * BasicDataSource basicDataSource = new BasicDataSource();
	 * basicDataSource.setUrl(dbUrl); basicDataSource.setUsername(username);
	 * basicDataSource.setPassword(password);
	 * 
	 * return basicDataSource; }
	 */
	@Override  
	public void run(String... args) throws Exception {
		//iAccountService.initAccount();


	}

}
