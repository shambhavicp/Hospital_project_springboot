package com.ty.springboot_hospitalproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.repository.MedOrderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepository medOrderRepository;
	
	@Autowired
	private EncounterDao encounterDao;
	
	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}
	
	public MedOrder updateMedOrder(MedOrder medOrder, int mid) {
		if(medOrderRepository.findById(mid).isPresent()) {
		medOrder.setId(mid);
		return medOrderRepository.save(medOrder);
		}else {
			return null;
		}
	}
	
	public MedOrder deleteMedOrder(int mid) {
		if(medOrderRepository.findById(mid).isPresent()) {
			MedOrder medOrder=medOrderRepository.findById(mid).get();
			medOrderRepository.delete(medOrder);
			return medOrder;
		}else {
			return null;
		}
	}
	
	public MedOrder getMedOrderById(int mid) {
		if(medOrderRepository.findById(mid).isPresent()) {
			return medOrderRepository.findById(mid).get();
			
		}else {
			return null;
		}
	}
	
	public List<MedOrder> getAllMedOrderByEncounter(int eid){
		Encounter encounter=encounterDao.getEncounterById(eid);
		if(encounter!=null) {
		return medOrderRepository.getByEncounter(encounter);
		}else {
			return null;
		}
	}
	
}
