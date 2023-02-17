package com.ty.springboot_hospitalproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.HospitalDao;
import com.ty.springboot_hospitalproject.dto.Hospital;
import com.ty.springboot_hospitalproject.exception.HospitalIdNotFoundException;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveHospital(hospital));
		
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id ,Hospital hospital){
		
		Hospital daoHospital=dao.updateHospital(id, hospital);
		if(daoHospital!=null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoHospital);
			
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}else {
			throw new HospitalIdNotFoundException("Given Id Not Found");
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id){
		Hospital daoHospital=dao.deleteHospital(id);
		if(daoHospital!=null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoHospital);
			
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}else {
			throw new HospitalIdNotFoundException("Given Id Not Found");
			
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id){
		Hospital daoHospital=dao.getHospitalById(id);
		if(daoHospital!=null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoHospital);
			
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new HospitalIdNotFoundException("Given Id Not Found");
			
		}
	}
	
	
	
	
}
