package com.revature.poa.service;

import java.util.List;


import com.revature.poa.model.Patient;

public interface PatientService {

	public boolean addPatient(Patient patient);
	public boolean updatePatientDetails(Patient patient);
	public Patient getPatientDetails(String patientEmail);
	public boolean isPatientExist(String patientEmail);
	public List<Patient> getAllPatientDetails();
	public boolean authenticatePatient(String patientEmail,String password);
	public boolean deletePatient(String patientEmail);
}
