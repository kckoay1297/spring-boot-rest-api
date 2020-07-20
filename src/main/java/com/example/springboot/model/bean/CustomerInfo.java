package com.example.springboot.model.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8037397965781648757L;

	@Id
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "TEL_PHONE")
	private String telPhone;
	
	@Column(name = "HAND_PHONE")
	private String handPhone;
	
	@Column(name = "NRIC")
	private String nric;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "JOIN_dATE")
	private Date joinDate;
	
	@Column(name = "HOME_ADDRESS1")
	private String homeAddress1;
	
	@Column(name = "HOME_ADDRESS2")
	private String homeAddress2;
	
	@Column(name = "HOME_ZIP")
	private String homeZip;
	
	@Column(name = "HOME_CITY")
	private String homeCity;
	
	@Column(name = "HOME_STATE")
	private String homeState;
	
	@Column(name = "HOME_COUNTRY")
	private String homeCountry;

	@Column(name = "CUSTOMER_TYPE")
	private String customerType;
	
	@Column(name = "STATUS")
	private String status;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getHandPhone() {
		return handPhone;
	}

	public void setHandPhone(String handPhone) {
		this.handPhone = handPhone;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getHomeAddress1() {
		return homeAddress1;
	}

	public void setHomeAddress1(String homeAddress1) {
		this.homeAddress1 = homeAddress1;
	}

	public String getHomeAddress2() {
		return homeAddress2;
	}

	public void setHomeAddress2(String homeAddress2) {
		this.homeAddress2 = homeAddress2;
	}

	public String getHomeZip() {
		return homeZip;
	}

	public void setHomeZip(String homeZip) {
		this.homeZip = homeZip;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeCountry() {
		return homeCountry;
	}

	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
