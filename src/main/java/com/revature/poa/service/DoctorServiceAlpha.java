package com.revature.poa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.poa.model.Doctor;
import com.revature.poa.repository.DoctorRepository;

@Service
public class DoctorServiceAlpha implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	public DoctorServiceAlpha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
		return true;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepository.save(doctor);
		return true;
	}

	@Override
	public Doctor getDoctorById(long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor=doctorRepository.findByDoctorId(doctorId);
		return doctor;
	}

	@Override
	public boolean isDoctorExist(long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor=doctorRepository.findByDoctorId(doctorId);
		if(doctor!=null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean deleteDoctorById(long doctorId) {
		// TODO Auto-generated method stub
		doctorRepository.deleteByDoctorId(doctorId);
		return true;
	}
	@Override
	public List<Doctor> getAllDoctorDetails() {
		// TODO Auto-generated method stub
		List<Doctor> doctor =(List<Doctor>) doctorRepository.findAll();
		return doctor;
	}

	@Override
	public boolean authenticateDoctor(long doctorId, String Password) {
		// TODO Auto-generated method stub
		Doctor doctor=doctorRepository.findByDoctorIdAndPassword(doctorId, Password);
		if(doctor!=null)
			return true;
		else
			return false;
	}


}
