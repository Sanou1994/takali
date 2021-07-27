package com.connecsen.oterrain.utils;

import org.modelmapper.ModelMapper;

import com.connecsen.oterrain.domaine.Role;
import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.RoleDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.TerrainDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.TournoiDtoRequest;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.RoleDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.TerrainDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.TournoiDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;

import net.bytebuddy.utility.RandomString;

public final class Utility {
	// CONSTANT POUR LA SECURITE
	public static final long EXPIRATION_TIME =5 * 60 * 60 ;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SECRET = "javainuse";

	
	// LES URLS D'ACCESS
	
	public static final String ADD_TOURNOI = "/tournoi/add";
	public static final String UPDATE_TOURNOI = "/tournoi/update";
	public static final String GET_TOURNOI_BY_ID = "/tournoi/tournois/{id}";
	public static final String DELETE_TOURNOI_BY_ID = "/tournoi/tournois/{id}";
	public static final String GET_ALL_TOURNOIS = "/tournoi/tournois";
	
	public static final String ADD_TERRAIN = "/terrain/add";
	public static final String UPDATE_TERRAIN = "/terrain/update";
	public static final String GET_TERRAIN_BY_ID = "/terrain/terrains/{id}";
	public static final String DELETE_TERRAIN_BY_ID = "/terrain/terrains/{id}";
	public static final String GET_ALL_TERRAINS = "/terrain/terrains";
	
	public static final String ADD_USER = "/user/add";
	public static final String UPDATE_USER = "/user/update";
	public static final String GET_USER_BY_ID = "/user/users/{id}";
	public static final String DELETE_USER_BY_ID = "/user/users/{id}";
	public static final String GET_ALL_USERS = "/user/users";
	
	public static final String ADD_ROLE = "/user/role/add";
	public static final String UPDATE_ROLE = "/user/role/update";
	public static final String GET_ROLE_BY_ID = "/user/role/roles/{id}";
	public static final String DELETE_ROLE_BY_ID = "/user/role/roles/{id}";
	public static final String GET_ALL_ROLES = "/user/role/roles";
	
	public static final String DO_REGISTER = "/user/register";
	public static final String DO_LOGIN = "/user/login";
	public static final String DO_FORGOT_PASSWORD = "/user/forgot";
	public static final String DO_UPDATE_PASSWORD = "/user/updatePassword";
	
	
	//GENERATEUR DE TOKEN POUR RECUPERER LE MOT DE PASSE
	public static String getTokenResetPassword() {
		return RandomString.make(30);
	}
	
	//LES MAPPERS DTO A DAO ROLE
		public static  RoleDtoResponse roleConvertToRoleDtoResponse(Role role) {
			ModelMapper modelMapper = new ModelMapper(); 
			RoleDtoResponse roleDtoResponse = new RoleDtoResponse() ;
		    return (role != null)? modelMapper.map(role, RoleDtoResponse.class) : roleDtoResponse;
		}
		public static  Role RoleDtoResponseConvertToRole(RoleDtoResponse roleDtoResponse) {
			ModelMapper modelMapper = new ModelMapper(); 
			Role role = modelMapper.map(roleDtoResponse, Role.class);
		    return role;
		}
		public static Role RoleDtoRequestConvertToRole(RoleDtoRequest roleDtoRequest)  {
			ModelMapper modelMapper = new ModelMapper();
			Role role = modelMapper.map(roleDtoRequest, Role.class);
		    return role;
		}


	//LES MAPPERS DTO A DAO USER
	public static  UserDtoResponse utilisateurConvertToUserDtoResponse(Utilisateur utilisateur) {
		ModelMapper modelMapper = new ModelMapper(); 
		UserDtoResponse userDtoResponse = new UserDtoResponse() ;
	    return (utilisateur != null)? modelMapper.map(utilisateur, UserDtoResponse.class) : userDtoResponse;
	}
	public static  Utilisateur userDtoResponseConvertToUtilisateur(UserDtoResponse userDtoResponse) {
		ModelMapper modelMapper = new ModelMapper(); 
		Utilisateur utilisateur = modelMapper.map(userDtoResponse, Utilisateur.class);
	    return utilisateur;
	}
	public static Utilisateur userDtoRequestConvertToUtilisateur(UserDtoRequest userDtoRequest)  {
		ModelMapper modelMapper = new ModelMapper();
		Utilisateur utilisateur = modelMapper.map(userDtoRequest, Utilisateur.class);
	    return utilisateur;
	}
	
	//LES MAPPERS DTO A DAO TERRAIN
		public static  TerrainDtoResponse terrainConvertToTerrainDtoResponse(Terrain terrainDtoRequest) {
			ModelMapper modelMapper = new ModelMapper(); 
			TerrainDtoResponse terrainDtoResponse = new TerrainDtoResponse() ;
		    return (terrainDtoRequest != null)? modelMapper.map(terrainDtoRequest, TerrainDtoResponse.class) : terrainDtoResponse;
		}
		public static  Terrain terrainDtoResponseConvertToTerrain(TerrainDtoResponse terrainDtoResponse) {
			ModelMapper modelMapper = new ModelMapper(); 
			Terrain terrain = modelMapper.map(terrainDtoResponse, Terrain.class);
		    return terrain;
		}
		public static Terrain terrainDtoRequestConvertToTerrain(TerrainDtoRequest terrainDtoRequest)  {
			ModelMapper modelMapper = new ModelMapper();
			Terrain terrain = modelMapper.map(terrainDtoRequest, Terrain.class);
		    return terrain;
		}
		
		//LES MAPPERS DTO A DAO TOURNOI
				public static  TournoiDtoResponse tournoiConvertToTournoiDtoResponse(Tournoi tournoiDtoRequest) {
					ModelMapper modelMapper = new ModelMapper(); 
					TournoiDtoResponse tournoiDtoResponse = new TournoiDtoResponse() ;
				    return (tournoiDtoRequest != null)? modelMapper.map(tournoiDtoRequest, TournoiDtoResponse.class) : tournoiDtoResponse;
				}
				public static  Tournoi tournoiDtoResponseConvertToTournoi(TournoiDtoResponse tournoiDtoResponse) {
					ModelMapper modelMapper = new ModelMapper(); 
					Tournoi tournoi = modelMapper.map(tournoiDtoResponse, Tournoi.class);
				    return tournoi;
				}
				public static Tournoi tournoiDtoRequestConvertToTournoi(TournoiDtoRequest tournoiDtoRequest)  {
					ModelMapper modelMapper = new ModelMapper();
					Tournoi terrain = modelMapper.map(tournoiDtoRequest, Tournoi.class);
				    return terrain;
				}


}
