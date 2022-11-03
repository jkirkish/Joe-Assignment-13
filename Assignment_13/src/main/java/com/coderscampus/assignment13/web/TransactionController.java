package com.coderscampus.assignment13.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.assignment13.domain.Transaction;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.TransactionService;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transService;
	
	@GetMapping("/checking")
	public String getCheckingTransactions (ModelMap model) {
		Set<Transaction> transactions = transService.findAll();
		
		model.put("transactions", transactions);
		if (transactions.size() == 1) {
			model.put("transaction", transactions.iterator().next());
		}
		
		return "checking";
	}
	
	@GetMapping("/saving")
	public String getSavingTransactions (ModelMap model) {
		Set<Transaction> transactions = transService.findAll();
		
		model.put("transactions", transactions);
		if (transactions.size() == 1) {
			model.put("transaction", transactions.iterator().next());
		}
		
		return "saving";
	}
	
	@PostMapping("/transactions/{transactionId}")
	public String postOneTransaction (Transaction transaction) {
		transService.saveTransaction(transaction);
		return "redirect:/transactions/"+transaction.transactionId();
	}
	
	@PostMapping("/transactions/{transactionId}/delete")
	public String deleteOneTransaction (@PathVariable Long transactionId) {
		transService.delete(transactionId);
		return "redirect:/transactions";
	}
}
