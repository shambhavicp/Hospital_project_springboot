package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "name not be null")
	@NotBlank(message = "name not be Blank")
	private String name;
	
	@NotNull(message = "manager name not be null")
	@NotBlank(message = "manager name not be Blank")
	private String manager;
	
	private long phone;
	
	@ManyToOne
	private Hospital hospital;
	
	@OneToOne
	private Address address;
	
	
	
	
}
