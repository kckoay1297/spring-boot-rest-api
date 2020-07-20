package com.example.springboot.model.dto;

import java.io.Serializable;
import java.util.Date;


public class CustomerDetailDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8746433049442512620L;

	private String customerId;
	
	private String telPhone;
	
	private String handPhone;
	
	private String nric;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private Date joinDate;
	
	private String homeAddress1;
	
	private String homeAddress2;
	
	private String homeZip;
	
	private String homeCity;
	
	private String homeState;
	
	private String homeCountry;
	
	private String isNewJoiner;
	
	private String status;
	
	private String type;

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

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomeCountry() {
		return homeCountry;
	}

	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}

	public String getIsNewJoiner() {
		return isNewJoiner;
	}

	public void setIsNewJoiner(String isNewJoiner) {
		this.isNewJoiner = isNewJoiner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
