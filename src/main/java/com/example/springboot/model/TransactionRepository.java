package com.example.springboot.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.model.bean.Transaction;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction ,Integer>, JpaSpecificationExecutor<Transaction>{

	Page<Transaction> findAll(Pageable pageable);
	
	Page<Transaction> findByCustomerId(String customerId, Pageable pageable);
	
	Page<Transaction> findByDescription(String description, Pageable pageable);
	
	Page<Transaction> findByAccountNumber(String accountNumber, Pageable pageable);
	
}
