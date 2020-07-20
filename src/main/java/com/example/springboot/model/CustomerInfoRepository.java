package com.example.springboot.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.model.bean.CustomerInfo;

@Repository
@Transactional
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, String>{

}
