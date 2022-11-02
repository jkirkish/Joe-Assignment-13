package com.coderscampus.assignment13.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.coderscampus.assignment13.service.TransactionService;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	

}
