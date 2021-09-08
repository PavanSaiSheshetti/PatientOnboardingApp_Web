package com.revature.poa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.poa.model.Appointment;
import com.revature.poa.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public boolean deleteAppointment(int appointmentNumber) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(appointmentNumber);
		return true;
	}
	

	@Override
	public List<Appointment> getAppointmentBySpecialistId(long specialistId) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList  = appointmentRepository.findBySpecializationId(specialistId);
		
		return appointmentList;
	}

	@Override
	public List<Appointment> getAppointmentByConsultingType(String consultingType) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList  = appointmentRepository.findByConsultingType(consultingType);
		return appointmentList;
	}

	@Override
	public List<Appointment> getAppointmentByDoctorId(long doctorId) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList  = appointmentRepository.findByDoctorId(doctorId);
		return appointmentList;
	}

	@Override
	public boolean addAppointments(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.save(appointment);
		return true;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList = (List<Appointment>) appointmentRepository.findAll();
		return appointmentList;
	}

	@Override
	public List<Appointment> getAppointmentsByStatusSuccess(@PathVariable String appointmentStatus) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList = appointmentRepository.findByAppointmentStatus(appointmentStatus);
		return appointmentList;
	}

	/*
	 * @Override public boolean addAppointmentToSpecialist(Appointment appointment)
	 * { // TODO Auto-generated method stub
	 * appointmentRepository.saveInSpecialist(appointment.getPatientEmail(),
	 * appointment.getSpecialist()); appointmentRepository.delete(appointment);
	 * return true; }
	 */


	
	
	

}
