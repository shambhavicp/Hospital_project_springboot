package com.ty.springboot_hospitalproject.exception;

import java.util.ArrayList;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospitalproject.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(HospitalIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hospitalIddNotFoundException(HospitalIdNotFoundException exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given Hospital id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFoundException(AddressIdNotFound exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given Address id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given Branch id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PersonIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> personIdNotFound(PersonIdNotFound exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given Person id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(EncounterIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> encounterIdNotFound(EncounterIdNotFound exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given Encounter id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedOrderIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> medOrderIdNotFound(MedOrderIdNotFound exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given MedOrder id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MedItemsIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> medItemsIdNotFound(MedItemsIdNotFound exp){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given MedItems id");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		List<ObjectError> error=ex.getAllErrors();
		
		Map<String, String> map=new LinkedHashMap<>();
		
		for(ObjectError err:error) {
			String fieldName=((FieldError)err).getField();
			String message=((FieldError)err).getDefaultMessage();
			
			map.put(fieldName,message);
			
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
		
	}

	
	
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exp, WebRequest request){
//	
		List<String> errors=new ArrayList<>();
//		
		//Set<ConstraintViolation<?>> violations=exp.getConstraintViolations();
		
		//ConstraintViolation<?> violation= violations.iterator().next();
			//
		//String message=violation.getMessage();
		for(ConstraintViolation<?> violation:exp.getConstraintViolations()) {

			errors.add(violation.getMessage());
		}
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}	
	
}
