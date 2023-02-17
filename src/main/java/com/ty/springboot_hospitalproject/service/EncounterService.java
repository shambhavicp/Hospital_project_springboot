package com.ty.springboot_hospitalproject.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.BranchDao;
import com.ty.springboot_hospitalproject.dao.EncounterDao;
import com.ty.springboot_hospitalproject.dao.PersonDao;
import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.exception.EncounterIdNotFound;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class EncounterService {
	

	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid){
		
		Person person=personDao.getPersonById(pid);
		
		Branch branch=branchDao.getBranchById(bid);
		
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<Branch>();
		list.add(branch);
		
		encounter.setList(list);
		
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.saveEncounter(encounter));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int eid, int bid){
		Encounter daoEncounter= encounterDao.getEncounterById(eid);
		
		Branch branch=branchDao.getBranchById(bid);
		List<Branch> list=daoEncounter.getList();
		list.add(branch);
		
		encounter.setList(list);
		encounter.setPerson(daoEncounter.getPerson());
		

		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterDao.updatEncounter(encounter, eid));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		
	}
	

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid){
		Encounter daoEncounter= encounterDao.deleteEncounter(eid);
		if(daoEncounter!=null) {
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(daoEncounter);
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		}else {
			throw new EncounterIdNotFound("Given Id Not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(int eid){
		Encounter daoEncounter= encounterDao.getEncounterById(eid);
		if(daoEncounter!=null) {
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(encounterDao.getEncounterById(eid));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new EncounterIdNotFound("Given Id Not Found");
		}
		
	}
	
	

}
