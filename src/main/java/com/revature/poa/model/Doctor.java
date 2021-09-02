package com.revature.poa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "poa.doctors")
@Data
public class Doctor {
	
	@Id
	private int doctorId;
	
	private String password;
	
	private String doctorName;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

}
