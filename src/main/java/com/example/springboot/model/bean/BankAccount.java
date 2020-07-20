package com.example.springboot.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 408656518576355357L;

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name ="ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "AVAILABLE_BALANCE")
	private BigDecimal availableBalance;
	
	@Column(name = "PENDING_BALANCE")
	private BigDecimal pendingBalance;
	
	@Column(name = "ACCT_STATUS")
	private String acctStatus;
	
	@Column(name = "CUSTOMER_ID")
	private String customerId;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BigDecimal getPendingBalance() {
		return pendingBalance;
	}

	public void setPendingBalance(BigDecimal pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
