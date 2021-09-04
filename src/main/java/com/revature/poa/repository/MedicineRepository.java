package com.revature.poa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.poa.model.Medicine;


public interface MedicineRepository extends CrudRepository<Medicine, Integer>{

	public List<Medicine> findByPatientEmail(String patientEmail);	
	
	
}
