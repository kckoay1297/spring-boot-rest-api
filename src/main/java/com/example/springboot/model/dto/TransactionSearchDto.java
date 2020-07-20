package com.example.springboot.model.dto;

import java.io.Serializable;

public class TransactionSearchDto implements Serializable{

	private static final long serialVersionUID = 502056290314639259L;

	private String accountNumber;
	
	private String customerId;
	
	private String description;
	
	private Integer page;
	
	private Integer size;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
}
