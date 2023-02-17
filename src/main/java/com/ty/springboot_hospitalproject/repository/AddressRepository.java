package com.ty.springboot_hospitalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalproject.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
