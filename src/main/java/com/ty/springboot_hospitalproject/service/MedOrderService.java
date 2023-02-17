package com.ty.springboot_hospitalproject.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.EncounterDao;
import com.ty.springboot_hospitalproject.dao.MedOrderDao;
import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.exception.MedOrderIdNotFound;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid){
		
		Encounter encounter=encounterDao.getEncounterById(eid);
		if(encounter!=null) {
		medOrder.setEncounter(encounter);
		
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new MedOrderIdNotFound("Given Id Not Found");
		}
	}
	
	

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int mid){
		MedOrder daoMedOrder= medOrderDao.getMedOrderById(mid);
		
		if(daoMedOrder!=null) {
			medOrder.setEncounter(daoMedOrder.getEncounter());
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(medOrderDao.updateMedOrder(medOrder, mid));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}else {
			throw new MedOrderIdNotFound("Given Id Not Found");
		}
		
	}
	

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int eid){
		MedOrder daoMedOrder= medOrderDao.deleteMedOrder(eid);
		if(daoMedOrder!=null) {
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(daoMedOrder);
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}else {
			throw new MedOrderIdNotFound("Given Id Not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int eid){
		MedOrder daoMedOrder= medOrderDao.getMedOrderById(eid);
		if(daoMedOrder!=null) {
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(medOrderDao.getMedOrderById(eid));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new MedOrderIdNotFound("Given Id Not Found");
		}
		
	}
	
	

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrderByEncounter(int eid){
		List<MedOrder> daoMedOrder =medOrderDao.getAllMedOrderByEncounter(eid);
		if(daoMedOrder!=null) {
			ResponseStructure<List<MedOrder>> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoMedOrder);
			return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new MedOrderIdNotFound("Id not Found");
		}
		
	}
	

}
