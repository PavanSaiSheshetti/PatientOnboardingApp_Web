package com.revature.poa.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.poa.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{
	public Doctor findByDoctorId(long doctorId);
	public Doctor findByDoctorIdAndPassword(long doctorId,String Password);
	public int deleteByDoctorId(long doctorId);
}
