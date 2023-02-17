package com.ty.springboot_hospitalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.MedItemsDao;
import com.ty.springboot_hospitalproject.dao.MedOrderDao;
import com.ty.springboot_hospitalproject.dto.MedItems;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.exception.MedItemsIdNotFound;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class MedItemsService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	@Autowired
	private MedItemsDao medItemsDao;
	
	
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int mid){
		
		MedOrder medOrder=medOrderDao.getMedOrderById(mid);
		if(medOrder!=null) {
		medItems.setMedOrder(medOrder);
		
		ResponseStructure<MedItems> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medItemsDao.saveMedItems(medItems));
		
		return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new MedItemsIdNotFound("Given Id Not Found");
		}
	}
	
	

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(MedItems medItems, int mid){
		MedItems daoMedItems= medItemsDao.getMedItemsById(mid);
		
		if(daoMedItems!=null) {
			medItems.setMedOrder(daoMedItems.getMedOrder());
		ResponseStructure<MedItems> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(medItemsDao.updateMedItems(medItems, mid));
		
		return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure,HttpStatus.OK);
		}else {
			throw new MedItemsIdNotFound("Given Id Not Found");
		}
		
	}
	

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int mid){
		MedItems daoMedItems= medItemsDao.deleteMedItems(mid);
		if(daoMedItems!=null) {
		ResponseStructure<MedItems> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(daoMedItems);
		
		return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure,HttpStatus.OK);
		}else {
			throw new MedItemsIdNotFound("Given Id Not Found");		}
		
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(int mid){
		MedItems daoMedItems= medItemsDao.getMedItemsById(mid);
		if(daoMedItems!=null) {
		ResponseStructure<MedItems> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(medItemsDao.getMedItemsById(mid));
		
		return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new MedItemsIdNotFound("Given Id Not Found");
		}
		
	}
	
	

	public ResponseEntity<ResponseStructure<List<MedItems>>> getAllMedItemsByMedOrder(int mid){
		List<MedItems> daoMedItems =medItemsDao.getAllMedItemsByMedOrder(mid);
		if(daoMedItems!=null) {
			ResponseStructure<List<MedItems>> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoMedItems);
			return new ResponseEntity<ResponseStructure<List<MedItems>>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new MedItemsIdNotFound("Given Id Not Found");
		}
		
	}

}
