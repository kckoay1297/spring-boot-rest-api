package com.example.springboot.rest.model;

public enum ResponseStatus {

	SUCCESS(1000,"Success"), FAILED(2000, "Failed");
	
	private final int code;
	private final String message;
	
	private ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
