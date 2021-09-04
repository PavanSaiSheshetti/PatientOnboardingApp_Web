package com.revature.poa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.poa.model.Medicine;
import com.revature.poa.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepository;
	
	@Override
	public boolean addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		 medicineRepository.save(medicine);
		return true;
	}

	@Override
	public List<Medicine> getMedicineByPatientEmail(String patientEmail) {
		// TODO Auto-generated method stub
		List<Medicine> medicineList = medicineRepository.findByPatientEmail(patientEmail);
		return medicineList;
	}

	@Override
	public boolean removeMedicine(int medicineNumber) {
		// TODO Auto-generated method stub
		medicineRepository.deleteById(medicineNumber);
		return true;
	}

	@Override
	public boolean isPatientEmailExists(String patientEmail) {
		// TODO Auto-generated method stub
		List<Medicine> medicineList = medicineRepository.findByPatientEmail(patientEmail);
		if(medicineList.size() == 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
