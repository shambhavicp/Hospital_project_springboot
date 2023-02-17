package com.ty.springboot_hospitalproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.repository.PersonRepository;


@Repository
public class PersonDao {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Person person, int id) {
		if(personRepository.findById(id).isPresent()) {
			person.setId(id);
			return personRepository.save(person);
		}else {
			return null;
		}
	}
	
	public Person deletePerson(int id) {
		if(personRepository.findById(id).isPresent()) {
			Person person=personRepository.findById(id).get();
			personRepository.delete(person);
			return person;
		}else {
			return null;
		}
		
	}
	
	public Person getPersonById(int id) {
		if(personRepository.findById(id).isPresent()) {
			return 	personRepository.findById(id).get();
		}else {
			return null;
		}
		
	}
	
}
