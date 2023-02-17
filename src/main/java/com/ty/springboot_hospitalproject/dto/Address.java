package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "city not be null")
	@NotBlank(message = "city not be Blank")
	private String city;
	
	@NotNull(message = "area not be null")
	@NotBlank(message = "area not be Blank")
	private String area;
	
	@NotNull(message = "street not be null")
	@NotBlank(message = "street not be Blank")
	private String street;
	
	@NotNull(message = "state not be null")
	@NotBlank(message = "state not be Blank")
	private String state;
	
	private int pincode;
	
	
	
	
}
