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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.poa.model.Appointment;
import com.revature.poa.service.AppointmentService;

@RestController
@RequestMapping("appointments")
@CrossOrigin(origins="http://localhost:4200")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("save")
	public ResponseEntity<String> addAppointments(@RequestBody Appointment appointment){
		ResponseEntity<String> responseEntity;
		String message = null;
		appointmentService.addAppointments(appointment);
		message = "Appointment saved successfully";
		responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAllAppointments(){
	
		ResponseEntity<List<Appointment>> responseEntity;
		List<Appointment> appointmentList = appointmentService.getAllAppointments();
		if(appointmentList.size() !=0) {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
		
	}
	
	@GetMapping("{specialistId}")
	public ResponseEntity<List<Appointment>> getAppointmentBySpecialistId(@PathVariable("specialistId") long specialistId){
		ResponseEntity<List<Appointment>> responseEntity;
		List<Appointment> appointmentList = appointmentService.getAppointmentBySpecialistId(specialistId);
		if(appointmentList.size() !=0) {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
	
	@GetMapping("mode/{consultingType}")
	public ResponseEntity<List<Appointment>> getAppointByConsultingType(@PathVariable String consultingType){
		ResponseEntity<List<Appointment>> responseEntity;
		List<Appointment> appointmentList = appointmentService.getAppointmentByConsultingType(consultingType);
		if(appointmentList.size() !=0) {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
	
	@DeleteMapping("delete/{appointmentNumber}")
	public ResponseEntity<String> deleteAppointments(@PathVariable("appointmentNumber") int appointmentNumber){
		ResponseEntity<String> responseEntity;
		String message = null;
		appointmentService.deleteAppointment(appointmentNumber);
		message = "Appointment Deleted successfully";
		responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping("/get/{doctorId}")
	public ResponseEntity<List<Appointment>> getAppointmentByDoctorId(@PathVariable("doctorId") long doctorId){
		ResponseEntity<List<Appointment>> responseEntity;
		List<Appointment> appointmentList = appointmentService.getAppointmentByDoctorId(doctorId);
		if(appointmentList.size() !=0) {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Appointment>> getAppointmentByStatus(@PathVariable("status") String status){
		ResponseEntity<List<Appointment>> responseEntity = null;
		List<Appointment> appointmentList = null;
		
		appointmentList = appointmentService.getAppointmentsByStatusSuccess(status);	 
		 if(appointmentList.size()!=0) {
			 responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);
		 }
		
		else {
			 responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;

	}
	
	
	
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

