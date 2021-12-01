package com.connecsen.oterrain;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.connecsen.oterrain.jobs.JobRunner;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.IMatchService;
import com.connecsen.oterrain.service.IReservationService;
@Configuration
@SpringBootApplication
public class OterrainApplication implements CommandLineRunner {
	
	@Autowired
    private ThreadPoolTaskScheduler taskScheduler;
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	IReservationService iReservationService; 
	@Autowired
	IAccountService iAccountService;
	@Autowired(required=true)
	IMatchService iMatchService;	

	public static void main(String[] args) {
		SpringApplication.run(OterrainApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
    @Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
    
	
	/*
	 * @PostConstruct public void scheduleRunnableWithCronTrigger() {
	 * taskScheduler.scheduleWithFixedDelay(new
	 * JobRunner(iReservationService,terrainRepository),1); }
	 */
	 
	 
	@Override  
	public void run(String... args) throws Exception {
		iAccountService.initAccount();

		System.out.println("Runnable Task with  on thread ");

	}
	
}
