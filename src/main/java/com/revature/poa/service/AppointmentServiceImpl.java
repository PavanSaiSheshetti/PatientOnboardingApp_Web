package com.revature.poa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.poa.model.Appointment;
import com.revature.poa.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepository;

	/*
	 * @Override public boolean addAppointmentToSpecialist(Appointment appointment)
	 * { // TODO Auto-generated method stub
	 * appointmentRepository.saveInSpecialist(appointment.getPatientEmail(),
	 * appointment.getSpecialist()); appointmentRepository.delete(appointment);
	 * return true; }
	 */

	@Override
	public boolean deleteAppointment(String patientEmail) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(patientEmail);
		return true;
	}

	@Override
	public List<Appointment> getAppointmentBySpecialists(String specialist) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList = appointmentRepository.findBySpecialist(specialist);
		return appointmentList;
	}

	@Override
	public List<Appointment> getAppointmentByConsultingType(String consultingType) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList =appointmentRepository.findByConsultingType(consultingType);
		return appointmentList;
	}

	@Override
	public boolean addAppointments(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.save(appointment);
		return true;
	}
	
	public List<Appointment> getAllAppointments(){
		List<Appointment> appointmnetList = (List<Appointment>) appointmentRepository.findAll();
		return appointmnetList;
	}

	
	
	

}
