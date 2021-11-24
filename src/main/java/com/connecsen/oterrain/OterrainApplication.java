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
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.IMatchService;
import com.connecsen.oterrain.service.IReservationService;
import com.connecsen.oterrain.service.ITerrainService;
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
//	@Autowired
//    private MatchRepository matchRepository;
//	@Autowired
    private UserRepository userRepository;
//	@Autowired
    private RoleRepository roleRepository;
//	@Autowired
//   private EquipeRepository equipeRepository;
//	@Autowired
//    private TournoiRepository tournoiRepository;
//	

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
	 * JobRunner(iReservationService,terrainRepository,userRepository),1000); }
	 */
    
	@Override  
	public void run(String... args) throws Exception {
	    
		System.out.println("Runnable Task with  on thread ");
//		System.out.println(Long.valueOf(calendar.get(Calendar.MONTH)+Long.valueOf("1")));
//		System.out.println("jour :"+Long.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
//		System.out.println("year :"+calendar.get(Calendar.YEAR));
//		String[] splitted = "peter,james,thomas".split(",");
//			System.out.println(" resultat split :"+Long.parseLong("09"));
		
		
//		Utilisateur user= userRepository.findById((long) 1).get();
	 //  	Terrain terrain= terrainRepository.findById((long) 1).get();
			//  Equipe equipe= equipeRepository.findById((long) 5).get();
//		  Match match= matchRepository.findById((long) 1).get(); 
//		  Equipe equipe1= equipeRepository.findById((long) 1).get(); 
		//  Tournoi tournoi=tournoiRepository.findById((long) 2).get(); 
//		// matchRepository.save(match);
		 // 	 equipe.getTournois().add(tournoi);
		 //  equipeRepository.save(equipe);
	//Tournoi tournoiUpdate=tournoiRepository.save(tournoi);
        //	RoleDtoResponse admin=iAccountService.createOrUpdateRole(new RoleDtoRequest("ADMIN"));
        	// 	RoleDtoResponse proprietaire=iAccountService.createOrUpdateRole(new RoleDtoRequest("PROPRIETAIRE_TERRAIN"));
        	// 	RoleDtoResponse visiteur=iAccountService.createOrUpdateRole(new RoleDtoRequest("VISITEUR"));
		//Role role= roleRepository.findById((long) 1).get();
		//System.out.println(role.getLibelle());
	 //Role role= roleRepository.findByLibelle("ADMIN");
        	//   RoleDtoResponse roleGot =iAccountService.getRoleById((long) 1);
        	//  	Role role =Utility.RoleDtoResponseConvertToRole(roleGot);
	//	MatchDtoRequest user= new MatchDtoRequest((long) 2, "11", "11", "11", "11", "11", "11", null, null, null, terrain, tournoi);
		//iMatchService.createOrUpdateMatch(user);
	//	Terrain terrain = new Terrain("HML", "HML", "HML", "HML", "HML", "HML", "HML", 9, 9, null, null, user);
        	//   	UserDtoRequest user= new UserDtoRequest("admin", "admin", "admin", "admin", "admin","MOUSSA", false, "admin","a@a", "admin", "admin", "admin", "admin","AAA5555", role, null,null,null, null);
			//UserDtoRequest user= new UserDtoRequest("proprietaire", "proprietaire", "proprietaire", "proprietaire", "proprietaire","proprietaire", false, "proprietaire","b@b", "proprietaire", "proprietaire", "proprietaire", "proprietaire", role,null,null, null, null);

        	//     UserDtoResponse userSave=iAccountService.login_up(user);
	//System.out.println("USER CREER EST :"+tournoiRepository.save(tournoi));
        //  System.out.println("fin");
	}
	
}
