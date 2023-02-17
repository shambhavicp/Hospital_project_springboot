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
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "name not be null")
	@NotBlank(message = "name not be Blank")
	private String name;
	
	@NotNull(message = "email not be null")
	@NotBlank(message = "email not be Blank")
	private String email;
	
	@NotNull(message = "gst is mandatory it should not be null")
	@NotBlank(message = "gst is mandatory it should not be blank")
	private String gst;
	
}
