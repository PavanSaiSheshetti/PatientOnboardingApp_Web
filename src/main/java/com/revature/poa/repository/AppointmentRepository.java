package com.revature.poa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.revature.poa.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	public List<Appointment> findBySpecializationId(long specialistId);

	public List<Appointment> findByConsultingType(String consultingType);
	
	public List<Appointment> findByDoctorId(long doctorId);
	
	public List<Appointment> findByPatientEmail(String patientEmail);
	
	public List<Appointment> findByAppointmentStatus(String appointmentStatus);
	

}
