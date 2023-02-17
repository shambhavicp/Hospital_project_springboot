package com.ty.springboot_hospitalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospitalproject.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	@Query("select h from Hospital h where h.email=?1")
	public Hospital getByEmail(String email);

}
