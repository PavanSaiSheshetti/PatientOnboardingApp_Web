package com.revature.poa.service;

import java.util.List;

import com.revature.poa.model.Medicine;

public interface MedicineService {

	public boolean addMedicine(Medicine medicine);
	
	public List<Medicine> getMedicineByPatientEmail(String patientEmail);
	
	public List<Medicine> getMedicines();
	
	public boolean isPatientEmailExists(String patientEmail);

	boolean removeMedicine(int medicineNumber);
	
	public List<Medicine> getMedicineByStatus(String status);
	
	public boolean updateStatus(int medicineNumber);	
}
