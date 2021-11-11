package com.connecsen.oterrain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connecsen.oterrain.domaine.Terrain;
import com.connecsen.oterrain.domaine.Tournoi;
import com.connecsen.oterrain.domaine.Transaction;
import com.connecsen.oterrain.domaine.UpdateTransactionObjet;
import com.connecsen.oterrain.domaine.Utilisateur;
import com.connecsen.oterrain.domaine.dto.request.TransactionDtoRequest;
import com.connecsen.oterrain.domaine.dto.response.TransactionDtoResponse;
import com.connecsen.oterrain.repository.TerrainRepository;
import com.connecsen.oterrain.repository.TournoiRepository;
import com.connecsen.oterrain.repository.TransactionRepository;
import com.connecsen.oterrain.repository.UserRepository;
import com.connecsen.oterrain.utils.Utility;
@Service
public class TransactionService implements ITransactionService{
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private TournoiRepository tournoiRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public TransactionDtoResponse createTransaction(TransactionDtoRequest tournoiDtoRequest) {
		Transaction tournoi = Utility.transactionDtoRequestConvertToTransaction(tournoiDtoRequest);
		TransactionDtoResponse tournoiDtoResponse = Utility.transactionConvertToTransactionDtoResponse(transactionRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public TransactionDtoResponse getTransactionById(Long id) {
		
		Transaction tournoi = transactionRepository.findById(id).get();
		TransactionDtoResponse tournoiDtoResponse = Utility.transactionConvertToTransactionDtoResponse(transactionRepository.save(tournoi));
		return tournoiDtoResponse;
	}

	@Override
	public List<TransactionDtoResponse> getAllTransactions() {
		List<Transaction> tournois =transactionRepository.findAll();
		 List<TransactionDtoResponse> tournoiDtoResponses = tournois.stream()
				 .map(utilisateur -> Utility.transactionConvertToTransactionDtoResponse(utilisateur)).collect(Collectors.toList());
		return tournoiDtoResponses;
	}

	@Override
	public boolean deleteTransaction(Long id) {
		boolean resultat = false;
		Transaction tournoi = transactionRepository.findById(id).get();
		if(tournoi != null) {
			transactionRepository.deleteById(id);
			resultat =true;
		}
		return resultat;
	
	}

	@Override
	public List<TransactionDtoResponse> getTransactionByUser(long idUser) {
		Utilisateur user =userRepository.findById(idUser).get();
		 List<TransactionDtoResponse> transactionDtoResponses = user.getTransactions().stream()
				 .map(transaction -> Utility.transactionConvertToTransactionDtoResponse(transaction)).collect(Collectors.toList());
		return transactionDtoResponses;
	}

	@Override
	public TransactionDtoResponse addTransactionFormUserToTerrain(long idUser, long idTerrain,
		TransactionDtoRequest transactionDtoRequest) {
		Transaction transaction = Utility.transactionDtoRequestConvertToTransaction(transactionDtoRequest);
		Utilisateur user =userRepository.findById(idUser).get();
		Terrain terrain =terrainRepository.findById(idTerrain).get();
		transaction.setUser(user);
		transaction.setTerrain(terrain);
		Transaction transactionGot = transactionRepository.save(transaction);
		user.getTransactions().add(transactionGot);
		terrain.getTransactions().add(transactionGot);
		terrainRepository.save(terrain);
		userRepository.save(user);
		TransactionDtoResponse transactionDtoResponse = Utility.transactionConvertToTransactionDtoResponse(transactionGot);
		return transactionDtoResponse;
	}

	@Override
	public TransactionDtoResponse addTransactionFormUserToTournoi(long idUser, long idTournoi,
			TransactionDtoRequest transactionDtoRequest) {
		Transaction transaction = Utility.transactionDtoRequestConvertToTransaction(transactionDtoRequest);
		Utilisateur user =userRepository.findById(idUser).get();
		Tournoi tournoi =tournoiRepository.findById(idTournoi).get();
		transaction.setUser(user);
		transaction.setTournoi(tournoi);;
		Transaction transactionGot = transactionRepository.save(transaction);
		user.getTransactions().add(transactionGot);
		tournoi.getTransactions().add(transactionGot);
		tournoiRepository.save(tournoi);
		userRepository.save(user);
		TransactionDtoResponse transactionDtoResponse = Utility.transactionConvertToTransactionDtoResponse(transactionGot);
		return transactionDtoResponse;
	}

	@Override
	public TransactionDtoResponse updateTransaction(UpdateTransactionObjet updateTransactionObjet) {
		Transaction transaction =transactionRepository.findById(updateTransactionObjet.getId()).get();
		transaction.setStatus(updateTransactionObjet.isStatus());
		TransactionDtoResponse tournoiDtoResponse = Utility.transactionConvertToTransactionDtoResponse(transactionRepository.save(transaction));
		return tournoiDtoResponse;
	}



}
