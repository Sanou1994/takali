package com.connecsen.oterrain.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	@GetMapping("/bonjour")
	public String getDeleteRole(){
		return "BONJOUR";
    }
	
}
