package com.ty.springboot_hospitalproject.exception;

public class PersonIdNotFound extends RuntimeException{
	
private String message="person id is not found ";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PersonIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public PersonIdNotFound( ) {
		
	}
		

}
