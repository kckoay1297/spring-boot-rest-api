package com.example.springboot.controller.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.TransactionRepository;
import com.example.springboot.model.bean.Transaction;
import com.example.springboot.model.dto.TransactionDto;
import com.example.springboot.model.dto.TransactionRestDto;
import com.example.springboot.model.dto.TransactionSearchDto;
import com.example.springboot.model.service.TransactionService;
import com.nimbusds.oauth2.sdk.util.StringUtils;

@RequestMapping("/transaction")
@RestController
public class TransactionRestController {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TransactionService transactionService;
	
	Logger logger = LoggerFactory.getLogger(TransactionRestController.class);
			
	@GetMapping("/search")
	public ResponseEntity<Map<String, Object>> searchTransactionByCriteria(@RequestParam(required = false) String accountNumber, 
			@RequestParam(required = false) String description, @RequestParam(required = false) String customerId, 
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
		
		try {
			TransactionSearchDto transactionSearchDto = convertToSearchDto(accountNumber, description, customerId, page, size);
			Page<Transaction> transactionPage = findTransactionPageBySearchDto(transactionSearchDto);
			List<Transaction> transactionList = new ArrayList<>();
			if(transactionPage != null) {
				transactionList = transactionPage.getContent();
			}
			
			if(CollectionUtils.isEmpty(transactionList)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				 Map<String, Object> response = new HashMap<>();
			     response.put("transactionList", transactionList);
			     response.put("currentPage", transactionPage.getNumber());
			     response.put("totalItems", transactionPage.getTotalElements());
			     response.put("totalPages", transactionPage.getTotalPages());
			     
			     return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	private Page<Transaction> findTransactionPageBySearchDto(TransactionSearchDto transactionSearchDto){
		int page = 0, size = 0;
		
		Page<Transaction> pageTrx = null;

		if(transactionSearchDto != null) {
			size = transactionSearchDto.getSize();
			page = transactionSearchDto.getPage();
			Pageable paging = PageRequest.of(page, size);
			
			if(StringUtils.isNotBlank(transactionSearchDto.getAccountNumber())) {
				pageTrx = transactionRepository.findByAccountNumber(transactionSearchDto.getAccountNumber(), paging);
			}else if(StringUtils.isNotBlank(transactionSearchDto.getCustomerId())) {
				pageTrx = transactionRepository.findByCustomerId(transactionSearchDto.getCustomerId(), paging);
			}else if(StringUtils.isNotBlank(transactionSearchDto.getDescription())) {
				pageTrx = transactionRepository.findByDescription(transactionSearchDto.getDescription(), paging);
			}else {
				pageTrx = transactionRepository.findAll(paging);
			}
			
		}
		
		return pageTrx;
	}
	
	@GetMapping("/search-filter")
	public ResponseEntity<TransactionRestDto> searchTransactionByCriteriaFilterBySelectedFields(@RequestParam(required = false) String accountNumber, 
			@RequestParam(required = false) String description, @RequestParam(required = false) String customerId, @RequestParam(required = false) String[] selectedFields,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
		
		logger.info("description" + description);
		logger.info("customerId" + customerId);
		logger.info("accountNumber" + accountNumber);
		try {
			TransactionSearchDto transactionSearchDto = convertToSearchDto(accountNumber, description, customerId, page, size);
			TransactionRestDto transactionDisplay = transactionService.findTransactionBySearchDto(transactionSearchDto, selectedFields);
			if(transactionDisplay == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
			    return new ResponseEntity<>(transactionDisplay, HttpStatus.OK);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	private TransactionSearchDto convertToSearchDto(String accountNumber, String transactionType, String customerId, int page, int size) {
		TransactionSearchDto transactionSearchDto = new TransactionSearchDto();
		transactionSearchDto.setAccountNumber(accountNumber);
		transactionSearchDto.setDescription(transactionType);
		transactionSearchDto.setCustomerId(customerId);
		transactionSearchDto.setPage(page);
		transactionSearchDto.setSize(size);
		return transactionSearchDto;
	}
	
	@PostMapping("/create")
	public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
		try {
			Transaction transactionCreated = transactionService.createAndReturnId(convertToBean(transactionDto));
			transactionDto.setTransactionId(transactionCreated.getTransactionId());
			return new ResponseEntity<>(transactionDto, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Transaction convertToBean(TransactionDto transactionDto) {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(transactionDto.getAccountNumber());
		transaction.setCustomerId(transactionDto.getCustomerId());
		transaction.setDescription(transactionDto.getDescription());
		transaction.setTrxAmount(transactionDto.getTrxAmount());
		transaction.setTrxDate(transactionDto.getTrxDate());
		return transaction;
	}
}
