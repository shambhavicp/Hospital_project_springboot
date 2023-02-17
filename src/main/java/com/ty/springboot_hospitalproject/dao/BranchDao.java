package com.ty.springboot_hospitalproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.dto.Hospital;
import com.ty.springboot_hospitalproject.repository.BranchRepository;

@Repository
public class BranchDao {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private AddressDao addressDao;
	
	public Branch saveBranch(int hid, int aid ,Branch branch) {
		Hospital hospital=hospitalDao.getHospitalById(hid);
		Address address=addressDao.getAddressById(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return branchRepository.save(branch);
	}
	
	public Branch updateBranch(Branch branch, int bid) {
		if(branchRepository.findById(bid).isPresent()) {
			Branch dbBranch=branchRepository.findById(bid).get();
			branch.setId(bid);
			branch.setHospital(dbBranch.getHospital());
			branch.setAddress(dbBranch.getAddress());
			return branchRepository.save(branch);
			
		}else {
			return null;
		}	
	}
	
	public Branch deleteBranch(int id) {
		
		if(branchRepository.findById(id).isPresent()) {
			Branch branch=branchRepository.findById(id).get();
			branchRepository.delete(branch);
			return branch;
		}else {
			return null;
		}		
	}
	
	public Branch getBranchById(int id) {
		if(branchRepository.findById(id).isPresent()) {
			return branchRepository.findById(id).get();
	
		}else {
			return null;
		}	
	}
	
	
	public List<Branch> getAllBranchByHospital(int hid){
		Hospital hospital=hospitalDao.getHospitalById(hid);
		
		if(hospital!=null) {
		return branchRepository.getByHospital(hospital);
		}else {
			return null;
		}
	}
 

	
}
