package com.coderscampus.assignment13.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.Transaction;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.TransactionRepository;
import com.coderscampus.assignment13.repository.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transRepo;
	
	public Set<Transaction> findAll () {
		return (Set<Transaction>) transRepo.findAll();
	}
	

}
