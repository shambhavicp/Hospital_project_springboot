package com.ty.springboot_hospitalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalproject.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
