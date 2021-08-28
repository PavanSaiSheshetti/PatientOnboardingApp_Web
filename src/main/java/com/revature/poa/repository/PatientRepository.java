package com.revature.poa.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.poa.model.Patient;

public interface PatientRepository extends CrudRepository<Patient,Integer>{
	public Patient findByPatientEmail(String patientEmail);
	public Patient findByPatientEmailAndPassword(String patientEmail,String Password);
}
