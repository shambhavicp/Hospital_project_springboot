package com.ty.springboot_hospitalproject.exception;

public class HospitalIdNotFoundException extends RuntimeException{

	private String message="hospital Id not found";
	
	public String getMessage() {
		return message;
	}

	public HospitalIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public HospitalIdNotFoundException() {
		super();
	}
	
	
}
