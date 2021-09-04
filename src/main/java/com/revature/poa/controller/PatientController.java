package com.revature.poa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.poa.model.Patient;
import com.revature.poa.service.PatientService;

@Controller
@RequestMapping("patients")
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatient(){
		
		ResponseEntity<List<Patient>> responseEntity;
		List<Patient> patients=patientService.getAllPatientDetails();
		if(patients.size()!=0) {
			responseEntity=new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<List<Patient>>(patients,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@GetMapping("{patientEmail}")
	public ResponseEntity<Patient> getPatientDetails(@PathVariable("patientEmail")String patientEmail) {
		ResponseEntity<Patient> responseEntity;
		Patient patient=null;
		if(patientService.isPatientExist(patientEmail)) {
			patient=patientService.getPatientDetails(patientEmail);
			responseEntity=new ResponseEntity<Patient>(patient,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<Patient>(patient,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@PostMapping("save")
	public ResponseEntity<String> addPatient(@RequestBody Patient patient){
		ResponseEntity<String> responseEntity;
		String patientEmail=patient.getPatientEmail();
		String message=null;
		if(patientService.isPatientExist(patientEmail)) {
			message="patient with email already exist";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		else {
			message="patient added successfully";
			patientService.addPatient(patient);
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updatePatientDetails(@RequestBody Patient patient){
		System.out.println(patient);
		ResponseEntity<String> responseEntity;
		String message="patient updated successfully";
		patientService.updatePatientDetails(patient);
		responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("authenticate/{patientEmail}/{password}")
	public ResponseEntity<Boolean> authenticatePatient(@PathVariable("patientEmail")String patientEmail,
			@PathVariable("password")String password){
		ResponseEntity<Boolean> responseEntity;
		System.out.println("authenticate called");
		boolean value=patientService.authenticatePatient(patientEmail,password);
		if(value) {
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{patientEmail}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable("patientEmail") String patientEmail){
		ResponseEntity<Boolean> responseEntity;
		System.out.println("delete called");
		boolean result = patientService.deletePatient(patientEmail);
		if(result) {
			responseEntity = new ResponseEntity<Boolean>(result,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<Boolean>(result,HttpStatus.CONFLICT);
		}
		
		return responseEntity;
	}

}
