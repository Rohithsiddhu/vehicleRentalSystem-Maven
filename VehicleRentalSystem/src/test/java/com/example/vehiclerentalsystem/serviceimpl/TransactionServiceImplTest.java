package com.example.vehiclerentalsystem.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.vehiclerentalsystem.dto.TransactionDTO;
import com.example.vehiclerentalsystem.entity.Transaction;
import com.example.vehiclerentalsystem.repository.TransactionRepository;


class TransactionServiceImplTest {

	 @Mock
	    private PasswordEncoder passwordEncoder;

	    @Mock
	    private TransactionRepository transactionRepository;

	    @InjectMocks
	    private TransactionServiceImpl transactionService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testRegisterTransaction() {
	   
	        TransactionDTO transactionDto = createTransactionDTO();
	        Transaction transaction = createTransaction();
	        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        TransactionDTO result = transactionService.addTransaction(transactionDto);
	        
	        assertNotNull(result);
	        assertEquals(transaction.getTransactionId(), result.getTransactionId());
	        assertEquals(transaction.getTransactonType(), result.getTransactonType());
	        assertEquals(transaction.getAmount(), result.getAmount());
	        
	    }
	    
	    @Test
	    void testEditTransaction() {
	    	
	    	TransactionDTO transactionDto = createTransactionDTO();
	        Transaction transaction = createTransaction();
	        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        TransactionDTO result = transactionService.addTransaction(transactionDto);
	        
	        assertNotNull(result);
	        assertEquals(transaction.getTransactionId(), result.getTransactionId());
	        assertEquals(transaction.getTransactonType(), result.getTransactonType());
	        assertEquals(transaction.getAmount(), result.getAmount());
	    	
	    }
	    
	    @Test
	    void testDeleteTransaction() {
	       
	        int transactionId = 1;

	        
	        transactionService.deleteById((long) transactionId);

	        
	        verify(transactionRepository, times(1)).deleteById((long) transactionId);
	    }
	    
	    @Test
	    void testGetByTransactionId() throws Exception {
	       
	        int transactionId = 1;
	        Transaction transaction = createTransaction();
	        when(transactionRepository.findById((long) transactionId)).thenReturn(Optional.of(transaction));

	        
	        TransactionDTO result = transactionService.findById((long) transactionId);
	        
	        assertNotNull(result);
	        assertEquals(transaction.getTransactionId(), result.getTransactionId());
	        assertEquals(transaction.getTransactonType(), result.getTransactonType());
	        assertEquals(transaction.getAmount(), result.getAmount());
	    }
	    
	    @Test
	    void testGetAllTransactions() {
	        // Arrange
	    	 Transaction transaction1 = createTransaction();
	    	 Transaction transaction2 = createTransaction();
	        List<Transaction> transactions = List.of(transaction1,transaction2);
	        when(transactionRepository.findAll()).thenReturn(transactions);

	        
	        List<Transaction> result = transactionService.findAll();

	        
	        assertNotNull(result);
	        assertEquals(2, result.size());
	    }
	    
	    private TransactionDTO createTransactionDTO() {
	        return new TransactionDTO(1,"Paytm",2500.0);
	    }

	    private Transaction createTransaction() {
	    	Transaction transaction = new Transaction();
	        transaction.setTransactionId(1);
	        transaction.setTransactonType("Paytm");
	        transaction.setAmount(2500.0);
	       
	        return  transaction ; 
	    }
}
