package com.revature.poa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.poa.model.Medicine;

@Transactional
public interface MedicineRepository extends CrudRepository<Medicine, Integer>{

	public List<Medicine> findByPatientEmail(String patientEmail);	
	
	public List<Medicine> findByStatus(String status);

	@Modifying
	@Query("UPDATE Medicine m SET m.status = 'success' WHERE m.medicineNumber = :medicineNumber")
	public int updateStatus(@Param(value = "medicineNumber") int medicineNumber);
}
