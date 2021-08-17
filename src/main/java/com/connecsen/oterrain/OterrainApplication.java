package com.connecsen.oterrain;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.connecsen.oterrain.domaine.Equipe;
import com.connecsen.oterrain.domaine.Match;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.repository.EquipeRepository;
import com.connecsen.oterrain.repository.MatchRepository;
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.TournoiRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.IMatchService;

@SpringBootApplication
public class OterrainApplication implements CommandLineRunner{
	@Autowired
	IAccountService iAccountService;
	@Autowired(required=true)
	IMatchService iMatchService;
	@Autowired
    private MatchRepository matchRepository;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
   private EquipeRepository equipeRepository;
	@Autowired
    private TournoiRepository tournoiRepository;
	@Autowired
    private TerrainRepository terrainRepository;
	
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
//		Utilisateur user= userRepository.findById((long) 1).get();
//	   	Terrain terrain= terrainRepository.findById((long) 2).get();
		//	  Equipe equipe= equipeRepository.findById((long) 1).get();
//		  Match match= matchRepository.findById((long) 1).get(); 
//		  Equipe equipe1= equipeRepository.findById((long) 1).get(); 
		  Tournoi tournoi=tournoiRepository.findById((long) 1).get(); 
//		// matchRepository.save(match);
		  //	 equipe.getTournois().add(tournoi);
		  // equipeRepository.save(equipe);
	//Tournoi tournoiUpdate=tournoiRepository.save(tournoi);
		//RoleDtoRequest role=new RoleDtoRequest("ADMIN",null);
		  //iAccountService.createOrUpdateRole(role);
	//Utilisateur user= userRepository.findById((long) 1).get();
		//	 //Role role= roleRepository.findByLibelle("ADMIN");
		//	Role role= roleRepository.findById((long) 1).get();
	//	MatchDtoRequest user= new MatchDtoRequest((long) 2, "11", "11", "11", "11", "11", "11", null, null, null, terrain, tournoi);
		//iMatchService.createOrUpdateMatch(user);
	//	Terrain terrain = new Terrain("HML", "HML", "HML", "HML", "HML", "HML", "HML", 9, 9, null, null, user);
		//	UserDtoRequest user= new UserDtoRequest("admin", "admin", "admin", "admin", "admin", "admin","a@a", "admin", "admin", "admin", "admin", role, null, null);
	//UserDtoResponse userSave=iAccountService.login_up(user);
	//System.out.println("USER CREER EST :"+tournoiRepository.save(tournoi));
	
	}
}
