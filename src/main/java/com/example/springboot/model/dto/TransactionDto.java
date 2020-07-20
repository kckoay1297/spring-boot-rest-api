package com.example.springboot.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionDto implements Serializable{

	private static final long serialVersionUID = 3923994633089006492L;

	private Integer transactionId;
	
	private String accountNumber;
	
	private BigDecimal trxAmount;
	
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date trxDate;
	
	private String customerId;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getTrxAmount() {
		return trxAmount;
	}

	public void setTrxAmount(BigDecimal trxAmount) {
		this.trxAmount = trxAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	
}
