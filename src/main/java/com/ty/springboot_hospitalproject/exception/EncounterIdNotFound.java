package com.ty.springboot_hospitalproject.exception;

public class EncounterIdNotFound extends RuntimeException{
	
private String message="Encounter Id not found";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EncounterIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public EncounterIdNotFound( ) {
		
	}

}
