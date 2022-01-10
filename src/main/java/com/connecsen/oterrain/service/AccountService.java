package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.ListeHeureReserver;
import com.connecsen.oterrain.domaine.Reservation;
import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.UpdatePasswordUser;
import com.connecsen.oterrain.domaine.UserDoReservation;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.repository.ListerHeureRepository;
import com.connecsen.oterrain.repository.RoleRepository;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.UserDoReservationRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.security.JwtTokenUtil;
import com.connecsen.oterrain.utils.Utility;

@Service
@Transactional
public class AccountService implements IAccountService{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private IEmailService emailService;
	@Autowired
	private UserDetailsService userDetailsService;
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TerrainRepository terrainRepository;
    @Autowired
    private ListerHeureRepository reserverRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserDoReservationRepository userDoReservationRepository;
	
    @Autowired
	private IReservationService iReservationService;
    
	@Override
	public UserDtoResponse login_up(UserDtoRequest user) {
		Utilisateur userGot = userRepository.findByEmail(user.getEmail());
		UserDtoResponse userMap =null;
		if(userGot == null) {
			String pwdCryp = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(pwdCryp);
			Utilisateur userConverted =Utility.userDtoRequestConvertToUtilisateur(user);
			Utilisateur userSave = userRepository.save(userConverted);
			userMap = Utility.utilisateurConvertToUserDtoResponse(userSave);
		} else if(userGot.isUserDelete()==true) {
			emailService.sendEmailToActivateAccount(userGot.getNom(), userGot.getEmail());
		}
		
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
	public long updateResetPasswordToken(String token, String email) {
		Utilisateur user = userRepository.findByEmail(email);
        if (user != null) {
        	user.setResetPasswordToken(token);
        	String pwdCryp = bCryptPasswordEncoder.encode(token);
    		user.setPassword(pwdCryp);
        	userRepository.save(user);
        } else {
           
        }
		return user.getId();
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
		List<Utilisateur> utilisateurs =userRepository.findByUserDelete(false);
		List<UserDtoResponse> utilisateurDtoResponses = utilisateurs.stream()
				 .map(utilisateur -> Utility.utilisateurConvertToUserDtoResponse(utilisateur)).collect(Collectors.toList());
		return utilisateurDtoResponses;
		
	}
	@Override
	public boolean deleteUser(Long id) {
		Utilisateur user = userRepository.findById(id).get();
		boolean resultat =false;
		if(user != null)
		{		    userRepository.delete(user);
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
	@Override
	public UserDtoResponse addReservationToUser(long idUser, Reservation reservation) {
		Utilisateur userSave = userRepository.findById(idUser).get();
		reservation.setUser(userSave);
		userSave.getReservations().add(reservation);
		UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userRepository.save(userSave));
		return userDtoResponse;
	}
	@Override
	public UserDtoResponse addReservationToUserAndTerrain(long idReservation) {
		 Reservation reservation= iReservationService.getReservationById(idReservation);
		Terrain terrain =terrainRepository.findById(reservation.getIdTerrain()).get();
		
		String[]  date =reservation.getDateReservation().split("/");
		Utilisateur user =userRepository.findById(terrain.getIdUser()).get();
		
		String[] splitted =reservation.getHeure().split(",");
		UserDoReservation userDoReservation = new UserDoReservation();
		userDoReservation.setAdresse(user.getAdresse());
		userDoReservation.setIdUser(user.getId());
		userDoReservation.setNom(user.getNom());
		userDoReservation.setPrenom(user.getPrenom());
		userDoReservation.setTelephone(user.getTelephone());
		UserDoReservation userDoReservationCreate =userDoReservationRepository.save(userDoReservation);
		reservation.setUserDoReservation(userDoReservationCreate);
	
		for (int i = 0; i < splitted.length; i++) {
			ListeHeureReserver reserver = new ListeHeureReserver(
					reservation.getId(),
					Long.parseLong(date[0]),
					Long.parseLong(date[1]),
					splitted[i],null
					);
			ListeHeureReserver reserverSave =reserverRepository.save(reserver);
			terrainRepository.save(terrain);
			terrain.getListeHeureReserver().add(reserverSave);
		}
		terrainRepository.save(terrain);
		Utilisateur userSave=userRepository.save(user);
		UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userDtoResponse;
	}
	@Override
	public Utilisateur updatePasswordUser(UpdatePasswordUser updatePasswordUser) throws Exception {
		    Utilisateur user =userRepository.findById(updatePasswordUser.getIdUser()).get();
		    if((user != null)&&(bCryptPasswordEncoder.matches(updatePasswordUser.getOldPassword(), user.getPassword()))){
		        String encodedPassword = bCryptPasswordEncoder.encode(updatePasswordUser.getNewPassword()); 
		    	user.setPassword(encodedPassword);
			}else {
				throw new Exception("your oldpassword error ");
			}
	        return userRepository.save(user);
	}
	@Override
	public UserDtoResponse addReservationToUserAndTerrainWithoutPaid(long idUser, long idTerrain,
		Reservation reservationDtoRequest) {
		Utilisateur user =userRepository.findById(idUser ).get();
		Terrain terrain =terrainRepository.findById(idTerrain).get();
		 Reservation reservation= iReservationService.createOrUpdateReservation(reservationDtoRequest);
		 reservation.setTerrain(terrain);
		reservation.setUser(user);
		user.getReservations().add(reservation);
		terrain.getReservations().add(reservation);
		terrainRepository.save(terrain);
		Utilisateur userSave=userRepository.save(user);
		UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userSave);
		return userDtoResponse;
	}
	@Override
	public UserDtoResponse addReservationToUserAndTerrain(long idUser, long idTerrain,
			Reservation reservationDtoRequest) {
		    Reservation reservation= iReservationService.createOrUpdateReservation(reservationDtoRequest);
			Terrain terrain =terrainRepository.findById(idTerrain).get();
			
			String[]  date =reservation.getDateReservation().split("/");
			Utilisateur user =userRepository.findById(idUser ).get();
			 reservation.setTerrain(terrain);
				reservation.setUser(user);
				user.getReservations().add(reservation);
				terrain.getReservations().add(reservation);
				terrainRepository.save(terrain);
				userRepository.save(user);
			String[] splitted =reservation.getHeure().split(",");
			UserDoReservation userDoReservation = new UserDoReservation();
			userDoReservation.setAdresse(user.getAdresse());
			userDoReservation.setIdUser(user.getId());
			userDoReservation.setNom(user.getNom());
			userDoReservation.setPrenom(user.getPrenom());
			userDoReservation.setTelephone(user.getTelephone());
			UserDoReservation userDoReservationCreate =userDoReservationRepository.save(userDoReservation);
			reservation.setUserDoReservation(userDoReservationCreate);
		
			for (int i = 0; i < splitted.length; i++) {
				ListeHeureReserver reserver = new ListeHeureReserver(
						reservation.getId(),
						Long.parseLong(date[0]),
						Long.parseLong(date[1]),
						splitted[i],terrain
						);
				ListeHeureReserver reserverSave =reserverRepository.save(reserver);
				terrain.getListeHeureReserver().add(reserverSave);
				terrainRepository.save(terrain);
			}
			
			Utilisateur userSave=userRepository.save(user);
			UserDtoResponse userDtoResponse =Utility.utilisateurConvertToUserDtoResponse(userSave);
			return userDtoResponse;
	}
	@Override
	public Utilisateur getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public void initAccount() {
		List<UserDtoResponse> users=this.getAllUsers();
		boolean kane =false;
		boolean cedric =false;
		boolean mahamadi =false;
		boolean arouna =false;
		boolean ba =false;

		for (int i = 0; i < users.size(); i++) {
			switch (users.get(i).getEmail()) {
			case "sanouarouna90@gmail.com":
				arouna=true;
				break;
			case "bollky.nana@gmail.com":
					cedric=true;		
				break;
			case "aamadu.kane@gmail.com":
				kane=true;
				break;
			case "ouedraogomahamadi218@gmail.com":
				mahamadi=true;
				break;
			case "baamamad2018@outlook.fr":
				ba=true;
				break;
			default:
				break;
			}
		}
		if(kane == false) {
		Role role =roleRepository.findById((long) 1).get();
		Utilisateur adminCreate =new Utilisateur("aamadu.kane@gmail.com", "admin", "admin", "Dakar", "neant", "neant", "2021", false, "aamadu.kane@gmail.com", "774024131", "aamadu.kane@gmail.com", "neant",role, null, null, null, null);
		UserDtoRequest userDtoResponse =Utility.utilisateurConvertToUserDtoRequest(adminCreate);
		this.login_up(userDtoResponse);
		}
		if(cedric == false) {
			Role role =roleRepository.findById((long) 1).get();
			Utilisateur adminCreate =new Utilisateur("bollky.nana@gmail.com", "admin", "admin", "Dakar", "neant", "neant", "2021", false, "bollky.nana@gmail.com", "774024131", "bollky.nana@gmail.com", "neant",role, null, null, null, null);
			UserDtoRequest userDtoResponse =Utility.utilisateurConvertToUserDtoRequest(adminCreate);
			this.login_up(userDtoResponse);
			}
		if(mahamadi == false) {
			Role role =roleRepository.findById((long) 1).get();
			Utilisateur adminCreate =new Utilisateur("ouedraogomahamadi218@gmail.com", "admin", "admin", "Dakar", "neant", "neant", "2021", false, "ouedraogomahamadi218@gmail.com", "774024131", "ouedraogomahamadi218@gmail.com", "neant",role, null, null, null, null);
			UserDtoRequest userDtoResponse =Utility.utilisateurConvertToUserDtoRequest(adminCreate);
			this.login_up(userDtoResponse);
			}
		if(arouna == false) {
			Role role =roleRepository.findById((long) 1).get();
			Utilisateur adminCreate =new Utilisateur("sanouarouna90@gmail.com", "admin", "admin", "Dakar", "neant", "neant", "2021", false, "sanouarouna90@gmail.com", "774024131", "sanouarouna90@gmail.com", "neant",role, null, null, null, null);
			UserDtoRequest userDtoResponse =Utility.utilisateurConvertToUserDtoRequest(adminCreate);
			this.login_up(userDtoResponse);
			}
		if(ba == false) {
			Role role =roleRepository.findById((long) 1).get();
			Utilisateur adminCreate =new Utilisateur("baamamad2018@outlook.fr", "admin", "admin", "Dakar", "neant", "neant", "2021", false, "baamamad2018@outlook.fr", "774024131", "baamamad2018@outlook.fr", "neant",role, null, null, null, null);
			UserDtoRequest userDtoResponse =Utility.utilisateurConvertToUserDtoRequest(adminCreate);
			this.login_up(userDtoResponse);
			}
    	
	}
	
	}
