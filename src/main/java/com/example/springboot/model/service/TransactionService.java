package com.example.springboot.model.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.example.springboot.model.CustomerInfoRepository;
import com.example.springboot.model.TransactionRepository;
import com.example.springboot.model.bean.CustomerInfo;
import com.example.springboot.model.bean.Transaction;
import com.example.springboot.model.dto.CustomerDetailDto;
import com.example.springboot.model.dto.TransactionDto;
import com.example.springboot.model.dto.TransactionRestDto;
import com.example.springboot.model.dto.TransactionSearchDto;
import com.example.springboot.model.filter.TransactionSpecification;
import com.example.springboot.model.type.TrxFieldsTypeEnum;
import com.nimbusds.oauth2.sdk.util.StringUtils;

@Component
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	CustomerInfoRepository customerInfoRepository;
	
	public void add(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
	public Transaction getTransaction(int transactionId) {
		return transactionRepository.getOne(transactionId);
	}
	
	public List<Transaction> findTransactionBySearchDto(TransactionSearchDto transactionSearchDto){
		List<Transaction> transactionList = new ArrayList<>();
		int page = 0, size = 0;
		
		if(transactionSearchDto != null) {
			size = transactionSearchDto.getSize();
			page = transactionSearchDto.getPage();
			Pageable paging = PageRequest.of(page, size);
			
			Page<Transaction> pageTrx;
			
			Specification<Transaction> spec = new TransactionSpecification(convertToSpec(transactionSearchDto));
			pageTrx = transactionRepository.findAll(spec, paging);
			
			transactionList = pageTrx.getContent();
		}
		
		return transactionList;
	}
	
	private Transaction convertToSpec(TransactionSearchDto transactionDto) {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(transactionDto.getAccountNumber());
		transaction.setCustomerId(transactionDto.getCustomerId());
		transaction.setDescription(transactionDto.getDescription());
		return transaction;
	}
	
	public TransactionRestDto findTransactionBySearchDto(TransactionSearchDto transactionSearchDto, String[] selectedFields){
		TransactionRestDto transactionRestDto = new TransactionRestDto();
		List<Transaction> transactionList = new ArrayList<>();
		int page = 0, size = 0;
		
		if(transactionSearchDto != null) {
			size = transactionSearchDto.getSize();
			page = transactionSearchDto.getPage();
			Pageable paging = PageRequest.of(page, size);
			
			Specification<Transaction> spec = new TransactionSpecification(convertToSpec(transactionSearchDto));
			Page<Transaction> pageTrx = transactionRepository.findAll(spec, paging);
					
			boolean isAllSelected = false;
			boolean isAcctNoSelected = false;
			boolean isCustomerIdSelected = false;
			boolean isDescriptionSelected = false;
			boolean isTrxAmountSelected = false;
			boolean isTrxDateSelected = false;
			boolean isTrxIdSelected = false;
			boolean isCustomerDetailsSelected = false;

			if(selectedFields != null) {
				List<String> selectedFieldList = Arrays.asList(selectedFields);
				if(selectedFieldList.contains(TrxFieldsTypeEnum.ALL.toString())) {
					isAllSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.ACCOUNT_NUMBER.toString())) {
					isAcctNoSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.CUSTOMER_ID.toString())) {
					isCustomerIdSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.DESCRIPTION.toString())) {
					isDescriptionSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.TRX_AMOUNT.toString())) {
					isTrxAmountSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.TRX_DATE.toString())) {
					isTrxDateSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.TRANSACTION_ID.toString())) {
					isTrxIdSelected = true;
				}
				if(selectedFieldList.contains(TrxFieldsTypeEnum.CUSTOMER_DETAILS.toString())) {
					isCustomerDetailsSelected = true;
				}
			}else {
				isAllSelected = true;
			}
			
			transactionList = pageTrx.getContent();
			List<TransactionDto> transactionDtoList = new ArrayList<>();
			Set<String> customerIdSet = new HashSet<>();
			for(Transaction transaction: transactionList) {
				TransactionDto transactionDto = new TransactionDto();
				if(isAllSelected || isAcctNoSelected) {
					transactionDto.setAccountNumber(transaction.getAccountNumber());
				}
				if(isAllSelected || isCustomerIdSelected) {
					transactionDto.setCustomerId(transaction.getCustomerId());
				}
				if(isAllSelected || isDescriptionSelected) {
					transactionDto.setDescription(transaction.getDescription());
				}
				if(isAllSelected || isTrxAmountSelected) {
					transactionDto.setTrxAmount(transaction.getTrxAmount());
				}
				if(isAllSelected || isTrxDateSelected) {
					transactionDto.setTrxDate(transaction.getTrxDate());
				}
				if(isAllSelected || isTrxIdSelected) {
					transactionDto.setTransactionId(transaction.getTransactionId());
				}
				
				if(isCustomerDetailsSelected) {
					customerIdSet.add(transaction.getCustomerId());
				}
				transactionDtoList.add(transactionDto);
			}
			
			transactionRestDto.setCurrentPage(pageTrx.getNumber());
			transactionRestDto.setTotalItems(pageTrx.getTotalElements());
			transactionRestDto.setTotalPages(pageTrx.getTotalPages());
			transactionRestDto.setTransactionList(transactionDtoList);
			transactionRestDto.setSelectedFields(selectedFields);
			
			if(isCustomerDetailsSelected) {
				Map<String, CustomerDetailDto> customerDetailsMap = new HashMap<>();
				LocalDateTime sixMonthAgoTime = LocalDateTime.now().plusMonths(-6);
				for(String customerId: customerIdSet) {
					CustomerInfo customerInfo = customerInfoRepository.getOne(customerId);
					if(customerInfo != null) {
						CustomerDetailDto customerDetail = convertCustomerToDto(customerInfo, sixMonthAgoTime);
						customerDetailsMap.put(customerDetail.getCustomerId(), customerDetail);
					}
				}
				
				transactionRestDto.setCustomerIdMap(customerDetailsMap);
			}
		}
		
		return transactionRestDto;
	}
	
	private CustomerDetailDto convertCustomerToDto(CustomerInfo customerInfo, LocalDateTime sixMonthAgoTime) {
		CustomerDetailDto customerDetailDto = new CustomerDetailDto();
		customerDetailDto.setCustomerId(customerInfo.getCustomerId());
		customerDetailDto.setEmail(customerInfo.getEmail());
		customerDetailDto.setFirstName(customerInfo.getFirstName());
		customerDetailDto.setGender(customerInfo.getGender());
		customerDetailDto.setHandPhone(customerInfo.getHandPhone());
		customerDetailDto.setHomeAddress1(customerInfo.getHomeAddress1());
		customerDetailDto.setHomeAddress2(customerInfo.getHomeAddress2());
		customerDetailDto.setHomeCity(customerInfo.getHomeCity());
		customerDetailDto.setHomeCountry(customerInfo.getHomeCountry());
		customerDetailDto.setHomeState(customerInfo.getHomeState());
		customerDetailDto.setHomeZip(customerInfo.getHomeZip());
		customerDetailDto.setJoinDate(customerInfo.getJoinDate());
		if(customerInfo.getJoinDate() != null) {
			LocalDateTime joinedDateTime = LocalDateTime.ofInstant(customerInfo.getJoinDate().toInstant(),
                    ZoneId.systemDefault());
			if(joinedDateTime.isBefore(sixMonthAgoTime)) {
				customerDetailDto.setIsNewJoiner("N");
			}else {
				customerDetailDto.setIsNewJoiner("Y");
			}
		}

		customerDetailDto.setLastName(customerInfo.getLastName());
		customerDetailDto.setNric(customerInfo.getNric());
		customerDetailDto.setStatus(customerInfo.getStatus());
		customerDetailDto.setTelPhone(customerInfo.getTelPhone());
		customerDetailDto.setType(customerInfo.getCustomerType());
		return customerDetailDto;
	}
	
	public Transaction createAndReturnId(Transaction transaction) {
		Transaction newTransactionCreated = transactionRepository.save(transaction);
		return newTransactionCreated;
	}
}
