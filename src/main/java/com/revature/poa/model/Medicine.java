package com.revature.poa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "poapp.medicines")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicineNumber;

	private String patientEmail;
	
	private String medicineName;
	
	private int quantity;
	
	private float price;
	
	private String status;
	
	public Medicine() {
		// TODO Auto-generated constructor stub
	}

}
