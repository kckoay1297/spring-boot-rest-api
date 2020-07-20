package com.example.springboot.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.model.bean.BankAccount;

@Repository
@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccount, String>{

	List<BankAccount> findBankAcctByCustomerId(String customerId);
	List<BankAccount> findBankAcctByAccountNumber(String accountNumber);
}
