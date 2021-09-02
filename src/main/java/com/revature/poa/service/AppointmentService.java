package com.revature.poa.service;

import java.util.List;

import com.revature.poa.model.Appointment;

public interface AppointmentService {

	//public boolean addAppointmentToSpecialist(Appointment appointment);
	public boolean deleteAppointment(String patientEmail);
	public List<Appointment> getAppointmentBySpecialists(String specialist);
	public List<Appointment> getAppointmentByConsultingType(String consultingType);
	public boolean addAppointments(Appointment appointment);
	public List<Appointment> getAllAppointments();
}

