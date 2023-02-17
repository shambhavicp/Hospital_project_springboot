package com.ty.springboot_hospitalproject.exception;

public class MedItemsIdNotFound extends RuntimeException{
	
private String message="MedItems Id is Not found ";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MedItemsIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public MedItemsIdNotFound( ) {
		
	}

}
