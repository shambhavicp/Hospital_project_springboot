package com.ty.springboot_hospitalproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.repository.EncounterRepository;

@Repository
public class EncounterDao {
	
	@Autowired
	private EncounterRepository encounterRepository;

	
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepository.save(encounter);
	}
	
	public Encounter updatEncounter(Encounter encounter, int eid) {
		if(encounterRepository.findById(eid).isPresent()) {
			encounter.setId(eid);
			return encounterRepository.save(encounter);
		}else {
			return null;
		}
	}

	public Encounter getEncounterById(int eid) {
		// TODO Auto-generated method stub
		return encounterRepository.findById(eid).get();
	}

	public Encounter deleteEncounter(int eid) {
		if(encounterRepository.findById(eid).isPresent()) {
			Encounter encounter=encounterRepository.findById(eid).get();
			encounterRepository.delete(encounter);
			return encounter;
		}else {
			return null;
		}
	}
	
	
}
