package com.revature.poa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "poa.appointments")
@Data
public class Appointment {
	
	@Id
	private String patientEmail;
	
	private String specialist;
	
	private String symptoms;
	
	private String consultingType;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

}
