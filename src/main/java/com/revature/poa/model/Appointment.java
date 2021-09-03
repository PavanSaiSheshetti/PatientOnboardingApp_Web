package com.revature.poa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "poapp.appointments")
@Data
public class Appointment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentNumber;
	
	private String patientEmail;
	
	private long specializationId;
	
	private String symptoms;
	
	private long doctorId;
	
	private String consultingType;
	
	private String appointmentStatus;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

}
