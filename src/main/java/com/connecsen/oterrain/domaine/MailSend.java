package com.connecsen.oterrain.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MailSend {
	private String email;
	private String name;
    private String subject;
    private String message;

}
