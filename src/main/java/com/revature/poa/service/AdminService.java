package com.revature.poa.service;

import java.util.List;

import com.revature.poa.model.Appointment;
import com.revature.poa.model.Doctor;
import com.revature.poa.model.Medicine;
import com.revature.poa.model.Patient;

public interface AdminService {
	public boolean authenticateAdmin(String adminUserName,String adminPassword);
	//******* use patient service
//	public Patient getPatientDetails(String patientEmail);
//	public List<Patient> getAllPatientDetails();
	
	//*****use appointment service
//	public Appointment getAppointmentDetails(String patientEmail);
//	public List<Appointment> getAllAppointments();
//	public List<Appointment> getPendingAppointments();
//	public List<Appointment> getClosedAppointments();
	
	//******use doctor service
//	public Doctor getDoctorDetails();
//	public List<Doctor> getAllDoctors();
	
	//******use medicine service(like product)
//	public Medicine getMedicineDetails();
//	public List<Medicine> getAllMedicine();

	
}
