package com.example.springboot.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TransactionRestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3923994633089006492L;

	private Integer currentPage;
	private long totalItems;
	private Integer totalPages;
	private String[] selectedFields;
	private List<TransactionDto> transactionList;
	private Map<String, CustomerDetailDto> customerIdMap;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public List<TransactionDto> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<TransactionDto> transactionList) {
		this.transactionList = transactionList;
	}
	public String[] getSelectedFields() {
		return selectedFields;
	}
	public void setSelectedFields(String[] selectedFields) {
		this.selectedFields = selectedFields;
	}
	public Map<String, CustomerDetailDto> getCustomerIdMap() {
		return customerIdMap;
	}
	public void setCustomerIdMap(Map<String, CustomerDetailDto> customerIdMap) {
		this.customerIdMap = customerIdMap;
	}
	
}
