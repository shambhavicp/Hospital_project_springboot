package com.ty.springboot_hospitalproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.PersonDao;
import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.exception.PersonIdNotFound;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(person));
		
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person, int id){
		Person daoPerson=personDao.updatePerson(person, id);
		if(daoPerson!=null) {
			ResponseStructure<Person> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoPerson);
			
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}else {
			throw new PersonIdNotFound("No Element Found for the given id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id){
		Person daoPerson=personDao.deletePerson(id);
		if(daoPerson!=null) {
			ResponseStructure<Person> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoPerson);
			
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}else {
			throw new PersonIdNotFound("No Element Found for the given id");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
		Person daoPerson=personDao.getPersonById(id);
		if(daoPerson!=null) {
			ResponseStructure<Person> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoPerson);
			
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new PersonIdNotFound("No Element Found for the given id");
		}
	}
	
	
	

}
