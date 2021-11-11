package com.connecsen.oterrain.domaine.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionDtoRequest {
	private Long id;
	private Date date =new Date() ;
	private long order_number;
	private double montant;
	private String typeTransaction;
	private boolean status;
	public TransactionDtoRequest(Date date, long order_number, double montant, String typeTransaction, boolean status) {
		super();
		this.date = date;
		this.order_number = order_number;
		this.montant = montant;
		this.typeTransaction = typeTransaction;
		this.status = status;
	}
	
}
