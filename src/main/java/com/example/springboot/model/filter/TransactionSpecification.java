package com.example.springboot.model.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.springboot.model.bean.Transaction;

public class TransactionSpecification implements Specification<Transaction>{

	private static final long serialVersionUID = 1265706446549080L;
	
	private Transaction filter;
	
	public TransactionSpecification(Transaction filter) {
		super();
		this.filter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate p = criteriaBuilder.conjunction();
		
		if(filter.getAccountNumber() != null) {
			p.getExpressions()
				.add(criteriaBuilder.equal(root.get("accountNumber"), filter.getAccountNumber()));
		}
		
		if(filter.getCustomerId() != null) {
			p.getExpressions()
			.add(criteriaBuilder.equal(root.get("customerId"), filter.getCustomerId()));
		}
		
		if(filter.getDescription() != null) {
			p.getExpressions()
			.add(criteriaBuilder.equal(root.get("description"), filter.getDescription()));
		}
		
		return p;
	}

	
}
