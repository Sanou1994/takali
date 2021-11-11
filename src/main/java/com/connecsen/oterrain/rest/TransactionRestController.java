package com.connecsen.oterrain.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connecsen.oterrain.domaine.UpdateTransactionObjet;
import com.connecsen.oterrain.domaine.dto.request.TransactionDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TransactionDtoResponse;
import com.connecsen.oterrain.domaine.dto.response.UserDtoResponse;
import com.connecsen.oterrain.service.IAccountService;
import com.connecsen.oterrain.service.ITransactionService;
import com.connecsen.oterrain.utils.Utility;
@RestController
public class TransactionRestController {
	Logger logger = LoggerFactory.getLogger(TransactionRestController.class);
	@Autowired
	private ITransactionService iTransactionService;
	@Autowired
	private IAccountService accountService;
	
	@PostMapping(Utility.ADD_TRANSACTION)
	public TransactionDtoResponse ajouterTransaction( @RequestBody TransactionDtoRequest transaction) {
		TransactionDtoResponse tournoiAdd =iTransactionService.createTransaction(transaction);
		return tournoiAdd;
	}
	@PostMapping(Utility.UPDATE_TRANSACTION)
	public TransactionDtoResponse getUpdateTransaction( @RequestBody UpdateTransactionObjet updateTransactionObjet){
		return iTransactionService.updateTransaction(updateTransactionObjet);
    }
	@GetMapping(Utility.GET_ALL_TRANSACTIONS)
	public List<TransactionDtoResponse> getAllTransaction(){
		return iTransactionService.getAllTransactions();
    }
	@GetMapping(Utility.GET_TRANSACTION_BY_ID)
	public TransactionDtoResponse getTransactionById(@PathVariable(value = "id") Long userId){
		return iTransactionService.getTransactionById(userId);
    }
	@GetMapping(Utility.DELETE_TRANSACTION_BY_ID)
	public boolean getDeleteTransaction(@PathVariable(value = "id") Long userId){
		return iTransactionService.deleteTransaction(userId);
    }
	 @PostMapping(Utility.ADD_TRANSACTION_TO_USER_AND_TERRAIN)
		public TransactionDtoResponse getAddReservationUserAndTerrain( @PathVariable(value = "idTerrain") Long idTerrain, @PathVariable(value = "idUser") Long idUser, @RequestBody TransactionDtoRequest transactionDtoRequest){
		 UserDtoResponse userBefore =accountService.getUserById(idUser);
			TransactionDtoResponse resultatTransaction = iTransactionService.addTransactionFormUserToTerrain(idUser,idTerrain,transactionDtoRequest);
			UserDtoResponse userGot =accountService.getUserById(idUser);
			String succesResultat ="echec";
			if(userBefore.getTransactions().size() !=userGot.getTransactions().size()) {
				succesResultat = "success";
			}
	logger.info("username : "+  userGot.getUsername()+"with role : "+userGot.getRoles().getLibelle()+" tried to do transaction of terrain :"+
					" with  "+succesResultat);
			return resultatTransaction ;
	    }
	 
	 @PostMapping(Utility.ADD_TRANSACTION_TO_USER_AND_TOURNOI)
		public TransactionDtoResponse getAddReservationUserAndTournoi( @PathVariable(value = "idTournoi") Long idTournoi, @PathVariable(value = "idUser") Long idUser, @RequestBody TransactionDtoRequest transactionDtoRequest){
		 UserDtoResponse userBefore =accountService.getUserById(idUser);
			TransactionDtoResponse resultatTransaction = iTransactionService.addTransactionFormUserToTournoi(idUser,idTournoi,transactionDtoRequest);
			UserDtoResponse userGot =accountService.getUserById(idUser);
			String succesResultat ="echec";
			if(userBefore.getTransactions().size() !=userGot.getTransactions().size()) {
				succesResultat = "success";
			}
	logger.info("username : "+  userGot.getUsername()+"with role : "+userGot.getRoles().getLibelle()+" tried to do transaction of terrain :"+
					" with  "+succesResultat);
			return resultatTransaction ;
	    }
}
