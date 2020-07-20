package com.example.springboot.controller.transaction;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.BankAccountRepository;
import com.example.springboot.model.bean.BankAccount;

@RequestMapping("/account")
@RestController
public class BankAcctRestController {

	@Autowired
	BankAccountRepository bankAcctRepository;
	
	Logger logger = LoggerFactory.getLogger(BankAcctRestController.class);
	
	@GetMapping("/find-by-id")
	public ResponseEntity<List<BankAccount>> findAcctByCustomerId(@RequestParam(required=true) String customerId){
		try {
			List<BankAccount> bankAcctList = bankAcctRepository.findBankAcctByCustomerId(customerId);

			if(CollectionUtils.isEmpty(bankAcctList)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(bankAcctList, HttpStatus.OK);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-by-acct-no")
	public ResponseEntity<List<BankAccount>> getAcctByAcctNumber(@RequestParam(required=true) String accountNumber){
		try {
			List<BankAccount> bankAccounts = bankAcctRepository.findBankAcctByAccountNumber(accountNumber);
			if(CollectionUtils.isEmpty(bankAccounts)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
