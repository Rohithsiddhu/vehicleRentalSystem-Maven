package com.example.vehiclerentalsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.dto.TransactionDTO;
import com.example.vehiclerentalsystem.entity.Transaction;
import com.example.vehiclerentalsystem.repository.TransactionRepository;
import com.example.vehiclerentalsystem.service.ITransactionService;
@Service
public class TransactionServiceImpl implements ITransactionService {
	Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	@Autowired
	TransactionRepository repository;

	@Override
	public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
	 Transaction transaction = new Transaction();
	 BeanUtils.copyProperties(transactionDTO, transaction);
	  transaction = repository.save(transaction);
	  BeanUtils.copyProperties(transaction, transactionDTO);
	  logger.info("Transaction added successfully");
		return transactionDTO;
	}

	@Override
	public TransactionDTO updateTransaction(TransactionDTO transactionDTO) {
		
		Transaction transaction = new Transaction();
		 BeanUtils.copyProperties(transactionDTO, transaction);
		  transaction = repository.save(transaction);
		  BeanUtils.copyProperties(transaction, transactionDTO);
		  logger.info("Transaction updated successfully");
			return transactionDTO;
	}

	@Override
	public TransactionDTO findById(Long id) throws Exception {
	 TransactionDTO transactionDto = new TransactionDTO();
	 Transaction transaction = repository.findById(id).orElseThrow(() -> new Exception("Transaction not found - " + id));
	 BeanUtils.copyProperties(transaction, transactionDto);
	 logger.info("Transaction found with"+id);
		return transactionDto;
	}

	

	@Override
	public void deleteById(Long id) {
		repository.existsById(id);
		logger.info("Transaction deleted successfully");
		
	}

	@Override
	public List<Transaction> findAll() {
		 List<Transaction> transactionList = repository.findAll();
		 logger.info("Transaction List");
		 return transactionList;
	}

}
