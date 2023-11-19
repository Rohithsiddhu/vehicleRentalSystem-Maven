package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalsystem.dto.TransactionDTO;
import com.example.vehiclerentalsystem.entity.Transaction;
import com.example.vehiclerentalsystem.service.ITransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {
	
	@Autowired
	ITransactionService service;
	
	@PostMapping("/api/add")
	public TransactionDTO addTransaction(TransactionDTO transactionDto) {
		return service.addTransaction(transactionDto);
		
	}
	@PutMapping("/update/{id}")
	public TransactionDTO updateTransaction(@PathVariable Long id,@RequestBody TransactionDTO transactionDto) {
		return service.updateTransaction(transactionDto);
	}
	@GetMapping("/get/{id}")
	public TransactionDTO getById(@PathVariable Long id) throws Exception{
		return service.findById(id);
	}
	@GetMapping("/getall")
	public List<Transaction> findAll(){
		return service.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		 service.deleteById(id);
		
	}
	

}
