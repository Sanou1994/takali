package com.connecsen.oterrain.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
@GetMapping("/post")
public String messagePost() {
	
	return "je suis post";
}

@GetMapping("/get")
public String messageGet() {
	
	return "je suis get";
}


}
