package com.revature.poa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.poa.model.Admin;
import com.revature.poa.repository.AdminRepository;

@Service
public class AdminServiceAlpha implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	@Override
	public boolean authenticateAdmin(String adminUserName, String adminPassword) {
		Admin admin=adminRepository.findByAdminUserNameAndAdminPassword(adminUserName, adminPassword);
		if(admin!=null)
			return true;
		else
			return false;
	}


}
