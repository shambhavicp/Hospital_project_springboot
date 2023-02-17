package com.ty.springboot_hospitalproject.exception;

public class BranchIdNotFound extends RuntimeException{

private String message="Branch Id Not found";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BranchIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public BranchIdNotFound( ) {
		
	}
}
