package com.connecsen.oterrain.service;

import java.util.List;

import com.connecsen.oterrain.domaine.UpdateTransactionObjet;
import com.connecsen.oterrain.domaine.dto.request.TransactionDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TransactionDtoResponse;

public interface ITransactionService {
	//GESTION TRANSACTIONS
	  public TransactionDtoResponse createTransaction( TransactionDtoRequest transactionDtoRequest);
	  public TransactionDtoResponse updateTransaction( UpdateTransactionObjet updateTransactionObjet);
	  public  TransactionDtoResponse getTransactionById(Long id);
	  public List<TransactionDtoResponse> getAllTransactions();
	  public boolean deleteTransaction(Long id);
	  public List<TransactionDtoResponse> getTransactionByUser(long idUser);
	  public TransactionDtoResponse addTransactionFormUserToTerrain( long idUser,long idTerrain,TransactionDtoRequest transactionDtoRequest);
	  public TransactionDtoResponse addTransactionFormUserToTournoi( long idUser,long idTournoi,TransactionDtoRequest transactionDtoRequest);

}
