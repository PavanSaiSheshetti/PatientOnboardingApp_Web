package com.revature.poa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.revature.poa.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

	public List<Appointment> findBySpecialist(String specialist);

	public List<Appointment> findByConsultingType(String consultingType);
	

}
