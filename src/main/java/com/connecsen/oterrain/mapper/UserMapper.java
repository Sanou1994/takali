package com.connecsen.oterrain.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.UserDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;

public class UserMapper{
	@Autowired
    private ModelMapper modelMapper; 

	public UserDtoResponse utilisateurConvertToUserDtoResponse(Utilisateur utilisateur) {
		UserDtoResponse userDtoResponse = modelMapper.map(utilisateur, UserDtoResponse.class);
	    return userDtoResponse;
	}
	
	public Utilisateur userDtoRequestConvertToUtilisateur(UserDtoRequest postDto)  {
		Utilisateur utilisateur = modelMapper.map(postDto, Utilisateur.class);
	    return utilisateur;
	}
	
}
	
