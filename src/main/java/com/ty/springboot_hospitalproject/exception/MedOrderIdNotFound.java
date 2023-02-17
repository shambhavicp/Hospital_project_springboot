package com.ty.springboot_hospitalproject.exception;

public class MedOrderIdNotFound extends RuntimeException{
	
private String message="MedOrder id is not found";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MedOrderIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public MedOrderIdNotFound( ) {
		
	}

}
