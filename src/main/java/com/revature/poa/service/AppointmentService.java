package com.revature.poa.service;

import java.util.List;

import com.revature.poa.model.Appointment;

public interface AppointmentService {

	//public boolean addAppointmentToSpecialist(Appointment appointment);
	public boolean deleteAppointment(int appointmentNumber);
	public List<Appointment> getAppointmentBySpecialistId(long specialistId);
	public List<Appointment> getAppointmentByConsultingType(String consultingType);
	public List<Appointment> getAppointmentByDoctorId(long doctorId);
	public boolean addAppointments(Appointment appointment);
	public List<Appointment> getAllAppointments();
	public List<Appointment> getAppointmentsByStatusSuccess(String appointmentStatus);
}

