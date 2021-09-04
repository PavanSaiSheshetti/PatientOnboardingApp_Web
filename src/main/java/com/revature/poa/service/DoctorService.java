package com.revature.poa.service;

import java.util.List;

import com.revature.poa.model.Doctor;

public interface DoctorService {
	
	public boolean addDoctor(Doctor doctor);
	public boolean updateDoctor(Doctor doctor);
	public Doctor getDoctorById(long doctorId);
	public boolean isDoctorExist(long doctorId);
	public boolean deleteDoctorById(long doctorId);
	public List<Doctor> getAllDoctorDetails();
	public boolean authenticateDoctor(long doctorId,String Password);
}
