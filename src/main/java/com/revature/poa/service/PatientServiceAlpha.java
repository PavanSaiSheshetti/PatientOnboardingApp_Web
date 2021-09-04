package com.revature.poa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.poa.model.Patient;
import com.revature.poa.repository.PatientRepository;

@Service
public class PatientServiceAlpha implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	

	@Override
	public boolean addPatient(Patient patient) {
		patientRepository.save(patient);
		return true;
	}

	@Override
	public boolean updatePatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		patientRepository.save(patient);
		System.out.println("ghjbhk"+patient);
		return true;
	}

	@Override
	public Patient getPatientDetails(String patientEmail) {
		// TODO Auto-generated method stub
		Patient patient=patientRepository.findByPatientEmail(patientEmail);
		return patient;
	}

	@Override
	public boolean isPatientExist(String patientEmail) {
		// TODO Auto-generated method stub
		Patient patient=patientRepository.findByPatientEmail(patientEmail);
		if(patient!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<Patient> getAllPatientDetails() {
		// TODO Auto-generated method stub
		List<Patient>patient =(List<Patient>) patientRepository.findAll();
		return patient;
	}

	@Override
	public boolean authenticatePatient(String patientEmail, String Password) {
		// TODO Auto-generated method stub
		Patient patient=patientRepository.findByPatientEmailAndPassword(patientEmail, Password);
		if(patient!=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deletePatient(String patientEmail) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(patientEmail);
		return true;
	}


}
