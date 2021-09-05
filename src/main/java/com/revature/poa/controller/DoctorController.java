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

import com.revature.poa.model.Doctor;
import com.revature.poa.service.DoctorService;

@RestController
@RequestMapping("doctors")
@CrossOrigin(origins="http://localhost:4200")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@GetMapping
	public ResponseEntity<List<Doctor>> getDoctor(){
		
		ResponseEntity<List<Doctor>> responseEntity;
		List<Doctor> doctors=doctorService.getAllDoctorDetails();
		if(doctors.size()!=0) {
			responseEntity=new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<List<Doctor>>(doctors,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@GetMapping("{doctorId}")
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable("doctorId")long doctorId) {
		ResponseEntity<Doctor> responseEntity;
		Doctor doctor=null;
		if(doctorService.isDoctorExist(doctorId)) {
			doctor=doctorService.getDoctorById(doctorId);
			responseEntity=new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<Doctor>(doctor,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@PostMapping("save")
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
		ResponseEntity<String> responseEntity;
		long doctorId=doctor.getDoctorId();
		String message=null;
		if(doctorService.isDoctorExist(doctorId)) {
			message="doctor with id already exist";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		else {
			message="doctor added successfully";
			doctorService.addDoctor(doctor);
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateDoctorDetails(@RequestBody Doctor doctor){
		System.out.println(doctor);
		ResponseEntity<String> responseEntity;
		String message="Doctor updated successfully";
		doctorService.updateDoctor(doctor);
		responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("delete/{doctorId}")
	public ResponseEntity<String> deleteDoctorDetails(@PathVariable("doctorId")long doctorId){
		ResponseEntity<String> responseEntity;
		String message=null;
		if(doctorService.isDoctorExist(doctorId)) {
			doctorService.deleteDoctorById(doctorId);
			message="Doctor deleted successfully";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="no doctor found with that id";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@GetMapping("authenticate/{doctorId}/{password}")
	public ResponseEntity<Boolean> authenticateDoctor(@PathVariable("doctorId")long doctorId,
			@PathVariable("password")String password){
		ResponseEntity<Boolean> responseEntity;
		boolean value=doctorService.authenticateDoctor(doctorId,password);
		if(value) {
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
}
