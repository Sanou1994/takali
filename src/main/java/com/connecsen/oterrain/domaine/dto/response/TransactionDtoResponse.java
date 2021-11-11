package com.connecsen.oterrain.domaine.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionDtoResponse {
	private Long id;
	private Date date;
	private long order_number;
	private double montant;
	private String typeTransaction;
	private boolean status;
}
