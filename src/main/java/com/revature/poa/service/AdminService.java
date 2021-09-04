package com.revature.poa.service;

import java.util.List;

import com.revature.poa.model.Appointment;
import com.revature.poa.model.Doctor;
import com.revature.poa.model.Medicine;
import com.revature.poa.model.Patient;

public interface AdminService {

	public boolean authenticateAdmin(String adminUserName, String adminPassword);

	public Patient getPatientDetails(String patientEmail);

	public List<Patient> getAllPatientDetails();

	public Appointment getAppointmentDetails(String patientEmail);

	public List<Appointment> getAllAppointments();

	public List<Appointment> getPendingAppointments();

	public List<Appointment> getClosedAppointments();

	public Doctor getDoctorDetails();

	public List<Doctor> getAllDoctors();

	public Medicine getMedicineDetails();

	public List<Medicine> getAllMedicine();

}
