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
	public ResponseEntity<String> saveAppointments(@RequestBody Appointment appointment){
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
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.FOUND);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
		
	}
	
	@GetMapping("{specialist}")
	public ResponseEntity<List<Appointment>> getAppointmentBySpecialist(@PathVariable String specialist){
		ResponseEntity<List<Appointment>> responseEntity;
		List<Appointment> appointmentList = appointmentService.getAppointmentBySpecialists(specialist);
		if(appointmentList.size() !=0) {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.FOUND);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
	
	@GetMapping("get/{consultingType}")
	public ResponseEntity<List<Appointment>> getAppointByConsultingType(@PathVariable String consultingType){
		ResponseEntity<List<Appointment>> responseEntity;
		List<Appointment> appointmentList = appointmentService.getAppointmentByConsultingType(consultingType);
		if(appointmentList.size() !=0) {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.FOUND);
		}
		else {
			responseEntity = new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
	
	@DeleteMapping("delete/{patientEmail}")
	public ResponseEntity<String> deleteAppointments(@PathVariable("patientEmail") String patientEmail){
		ResponseEntity<String> responseEntity;
		String message = null;
		appointmentService.deleteAppointment(patientEmail);
		message = "Appointment Deleted successfully";
		responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		return responseEntity;
		
	}
	
	
	
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

