package com.connecsen.oterrain;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.IMatchService;

@SpringBootApplication
public class OterrainApplication implements CommandLineRunner{
	@Autowired
	IAccountService iAccountService;

	@Autowired(required=true)
	IMatchService iMatchService;
//	@Autowired
//    private MatchRepository matchRepository;
//	@Autowired
//    private UserRepository userRepository;
//	@Autowired
//    private RoleRepository roleRepository;
//	@Autowired
//   private EquipeRepository equipeRepository;
//	@Autowired
//    private TournoiRepository tournoiRepository;
//	@Autowired
//    private TerrainRepository terrainRepository;
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
	@Override
	public void run(String... args) throws Exception {
//		Calendar calendar = Calendar.getInstance();
//		System.out.println("calendar :"+calendar);
//		calendar.setTime(new Date());
//		System.out.println("date complet :"+new Date());
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
		//RoleDtoRequest role=new RoleDtoRequest("ADMIN",null);
		  //iAccountService.createOrUpdateRole(role);
	//Utilisateur user= userRepository.findById((long) 1).get();
	 //Role role= roleRepository.findByLibelle("ADMIN");
   //  Role role= roleRepository.findById((long) 1).get();
	//	MatchDtoRequest user= new MatchDtoRequest((long) 2, "11", "11", "11", "11", "11", "11", null, null, null, terrain, tournoi);
		//iMatchService.createOrUpdateMatch(user);
	//	Terrain terrain = new Terrain("HML", "HML", "HML", "HML", "HML", "HML", "HML", 9, 9, null, null, user);
	//	UserDtoRequest user= new UserDtoRequest("admin", "admin", "admin", "admin", "admin",false, "admin","a@a", "admin", "admin", "admin", "admin", role, null, null);
 //UserDtoResponse userSave=iAccountService.login_up(user);
	//System.out.println("USER CREER EST :"+tournoiRepository.save(tournoi));
	
	}
}
