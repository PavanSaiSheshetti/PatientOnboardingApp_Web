package com.revature.poa.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


//Naveed
@Data
@Entity
@Table(name="poapp.patients")
@AllArgsConstructor
public class Patient {

	private String firstName;
	private String lastName;
	@Id
	private String patientEmail;
	private String password;
	private String dateOfBirth;
	private String bloodGroup;
	private String city;
	private long phoneNumber;
	private long alternatePhoneNumber;
	private String alternateEmail;
	private long patientWeight;
	private long patientHeight;
	private Date lastLoggedInTime;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

}
