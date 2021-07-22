package com.connecsen.oterrain.rest;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.service.IAccountService;
@RestController
public class TestController {
	private IAccountService accountService;
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private ModelMapper modelMapper;
 
    
	public TestController(IAccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping("/dto")
	public UserDtoResponse getAllUser(){
		Utilisateur user  = new Utilisateur("arouna", "sanou", "Fass", "CINB", "AAA555", "9090", "@a", "3333", "Pass", null, null, null);
		UserDtoResponse carDto = modelMapper.map(user,UserDtoResponse.class);
		return carDto;
    }
}
