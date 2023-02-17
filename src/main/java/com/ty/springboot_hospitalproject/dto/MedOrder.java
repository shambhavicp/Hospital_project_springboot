package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Data
public class MedOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "date not be null")
	@NotBlank(message = "date not be Blank")
	private String date;
	
	@NotNull(message = "doctor not be null")
	@NotBlank(message = "doctor not be Blank")
	private String doctor;
	
	@ManyToOne
	private Encounter encounter;
	

}
