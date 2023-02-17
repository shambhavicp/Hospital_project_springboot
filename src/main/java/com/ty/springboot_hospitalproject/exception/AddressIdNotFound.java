package com.ty.springboot_hospitalproject.exception;

public class AddressIdNotFound extends RuntimeException{
	
	String message="address id not found";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public AddressIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public AddressIdNotFound( ) {
		
	}

}
