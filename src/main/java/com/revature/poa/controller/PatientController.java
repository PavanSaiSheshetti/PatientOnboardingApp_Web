package com.revature.poa.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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

import com.revature.poa.model.Patient;
import com.revature.poa.service.PatientService;

@RestController
@RequestMapping("patients")
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	Logger logger=Logger.getLogger("Patient controller");
	@GetMapping
	public ResponseEntity<List<Patient>> getPatient(){
//		********************************************************************
		logger.info(" getting all the patient details");
//		********************************************************************
		ResponseEntity<List<Patient>> responseEntity;
		List<Patient> patients=patientService.getAllPatientDetails();
		if(patients.size()!=0) {
//			********************************************************************
			logger.info(" get all the patient details");
//			********************************************************************
			responseEntity=new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		}
		else {
//			********************************************************************
			logger.info(" unable to get all the patient details");
//			********************************************************************
			responseEntity=new ResponseEntity<List<Patient>>(patients,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@GetMapping("{patientEmail}")
	public ResponseEntity<Patient> getPatientDetails(@PathVariable("patientEmail")String patientEmail) {
//		********************************************************************
		logger.info(" searching the patient by patient Email "+patientEmail);
//		********************************************************************
		ResponseEntity<Patient> responseEntity;
		Patient patient=null;
		if(patientService.isPatientExist(patientEmail)) {
//			********************************************************************
			logger.info(" retrieved the patient by patient Email "+patientEmail);
//			********************************************************************
			patient=patientService.getPatientDetails(patientEmail);
			responseEntity=new ResponseEntity<Patient>(patient,HttpStatus.OK);
		}
		else {
//			********************************************************************
			logger.info("Not found any patient details with patient email "+patientEmail);
//			********************************************************************
			responseEntity=new ResponseEntity<Patient>(patient,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@PostMapping("save")
	public ResponseEntity<String> addPatient(@RequestBody Patient patient){
//		********************************************************************
		logger.info(" saving patient details ");
//		********************************************************************
		ResponseEntity<String> responseEntity;
		String patientEmail=patient.getPatientEmail();
		String message=null;
		if(patientService.isPatientExist(patientEmail)) {
//			********************************************************************
			logger.info(" patient with same mail can't added ");
//			********************************************************************
			message="patient with email already exist";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		else {
//			********************************************************************
			logger.info(" saved patient with name : "+patient.getFirstName()+" "+patient.getLastName());
//			********************************************************************
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
//		********************************************************************
		logger.info(" updated the patient ");
//		********************************************************************
		responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("authenticate/{patientEmail}/{password}")
	public ResponseEntity<Boolean> authenticatePatient(@PathVariable("patientEmail")String patientEmail,
			@PathVariable("password")String password){
//		********************************************************************
		logger.info("Patient tried to Logged In at "+new Date());
//		********************************************************************
		ResponseEntity<Boolean> responseEntity;
		System.out.println("authenticate called");
		boolean value=patientService.authenticatePatient(patientEmail,password);
		if(value) {
//			********************************************************************
			logger.info("Patient Logged In Successfully");
//			********************************************************************
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.OK);
		}
		else {
//			********************************************************************
			logger.info("Patient Login Authentication failed");
//			********************************************************************
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{patientEmail}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable("patientEmail") String patientEmail){
//		********************************************************************
		logger.info(" deleting the patient details with patient name "+patientEmail);
//		********************************************************************
		ResponseEntity<Boolean> responseEntity;
		System.out.println("delete called");
		boolean result = patientService.deletePatient(patientEmail);
		if(result) {
//			********************************************************************
			logger.info(" deleted the patient details with patient name "+patientEmail);
//			********************************************************************
			responseEntity = new ResponseEntity<Boolean>(result,HttpStatus.OK);
		}
		else {
//			********************************************************************
			logger.info(" unable to delete the patient details with patient name "+patientEmail);
//			********************************************************************
			responseEntity = new ResponseEntity<Boolean>(result,HttpStatus.CONFLICT);
		}
		
		return responseEntity;
	}

}
