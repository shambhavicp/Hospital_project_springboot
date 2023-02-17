package com.ty.springboot_hospitalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.BranchDao;
import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.exception.BranchIdNotFound;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid,int aid){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(hid,aid, branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int bid){
		
		Branch daoBranch=branchDao.updateBranch(branch, bid);
		if(daoBranch!=null) {
			ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw new BranchIdNotFound("Id not Found");
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id){
		
		Branch daoBranch=branchDao.deleteBranch(id);
		if(daoBranch!=null) {
			ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw new BranchIdNotFound("Id not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id){
		
		Branch daoBranch=branchDao.getBranchById(id);
		if(daoBranch!=null) {
			ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new BranchIdNotFound("Id not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospital(int hid){
		List<Branch> daoBranch =branchDao.getAllBranchByHospital(hid);
		if(daoBranch!=null) {
			ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoBranch);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new BranchIdNotFound("Id not Found");
		}
		
	}
	
	
}
