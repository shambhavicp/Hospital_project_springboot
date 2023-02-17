package com.ty.springboot_hospitalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.AddressDao;
import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.exception.AddressIdNotFound;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveAddress(address));
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id ,Address address){
		
		Address daoAddress=dao.updateAddress(id, address);
		if(daoAddress!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoAddress);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new AddressIdNotFound("Given Id Not Found");
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id){
		Address daoAddress=dao.deleteAddress(id);
		if(daoAddress!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoAddress);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new AddressIdNotFound("Given Id Not Found");
			
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		Address daoAddress=dao.getAddressById(id);
		if(daoAddress!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoAddress);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFound("Given Id Not Found");
			
		}
	}
	
	
}
