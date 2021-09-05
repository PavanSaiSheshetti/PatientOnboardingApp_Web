package com.revature.poa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.poa.model.Medicine;
import com.revature.poa.service.MedicineService;

@RestController
@RequestMapping("medicines")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

	@Autowired
	MedicineService medicineService;

	@PostMapping("/save")
	public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {

		ResponseEntity<Boolean> responseEntity;
		boolean result = medicineService.addMedicine(medicine);
		if (result) {
			responseEntity = new ResponseEntity<Boolean>(result, HttpStatus.OK);

		} else {
			responseEntity = new ResponseEntity<Boolean>(result, HttpStatus.CONFLICT);

		}

		return responseEntity;

	}

	@GetMapping("/{patientEmail}")
	public ResponseEntity<List<Medicine>> getMedicineByPatientEmail(@PathVariable("patientEmail") String patientEmail) {
		ResponseEntity<List<Medicine>> responseEntity = null;
		List<Medicine> medicineList = null;
		medicineList = medicineService.getMedicineByPatientEmail(patientEmail);
		if (medicineList.size() != 0) {
			responseEntity = new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.OK);
		}

		else {
			responseEntity = new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.NO_CONTENT);
		}

		return responseEntity;

	}

	@DeleteMapping("/delete/{medicineNumber}")
	public ResponseEntity<Boolean> deleteMedicine(@PathVariable("medicineNumber") int medicineNumber) {
		ResponseEntity<Boolean> responseEntity = null;
		boolean result = false;
		result = medicineService.removeMedicine(medicineNumber);
		if (result) {
			responseEntity = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}

		else {
			responseEntity = new ResponseEntity<Boolean>(result, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@GetMapping
	public ResponseEntity<List<Medicine>> getMedicines() {
		ResponseEntity<List<Medicine>> responseEntity = null;
		List<Medicine> medicineList = medicineService.getMedicines();
		if (medicineList.size() != 0) {
			responseEntity = new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.NO_CONTENT);

		}

		return responseEntity;
	}

	@GetMapping("status/{status}")
	public ResponseEntity<List<Medicine>> getMedicines(@PathVariable("status") String status) {
		ResponseEntity<List<Medicine>> responseEntity = null;
		List<Medicine> medicineList = medicineService.getMedicineByStatus(status);
		if (medicineList.size() != 0) {
			responseEntity = new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.NO_CONTENT);

		}

		return responseEntity;
	}

	
	@PutMapping("updateStatus/{medicineNumber}")
	public ResponseEntity<Boolean> updateStatus(@PathVariable("medicineNumber") int medicineNumber) {
		ResponseEntity<Boolean> responseEntity = null;
		boolean result = false;
		result = medicineService.updateStatus(medicineNumber);
		if (result) {
			responseEntity = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Boolean>(result, HttpStatus.CONFLICT);
		}

		return responseEntity;
	}

}
