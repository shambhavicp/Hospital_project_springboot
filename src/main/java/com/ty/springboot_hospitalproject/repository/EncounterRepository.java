package com.ty.springboot_hospitalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalproject.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

}
