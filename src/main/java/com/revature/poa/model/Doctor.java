package com.revature.poa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "poapp.doctors")
@Data
public class Doctor {
	
	@Id
	private long doctorId;
	
	private String password;
	
	private String doctorName;
	
	private String specialization;
	
	private long specializationId;
	
	private String qualification;
	
	private String experience;
	
	private long phoneNumber;
	
	private String email;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

}
