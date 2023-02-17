package com.ty.springboot_hospitalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospitalproject.dto.MedItems;
import com.ty.springboot_hospitalproject.dto.MedOrder;

public interface MedItemsRepository extends JpaRepository<MedItems, Integer>{
	@Query("select m from MedItems m where m.medOrder=?1")
	public List<MedItems> getByMedOrder(MedOrder medOrder);

}
