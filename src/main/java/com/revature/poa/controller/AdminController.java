package com.revature.poa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.poa.service.AdminService;

@Controller
@RequestMapping("admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("authenticate/{adminUserName}/{adminPassword}")
	public ResponseEntity<Boolean> authenticateAdmin(@PathVariable("adminUserName")String adminUserName,
			@PathVariable("adminPassword")String adminPassword){
		ResponseEntity<Boolean> responseEntity;
		boolean value=adminService.authenticateAdmin(adminUserName,adminPassword);
		if(value) {
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.OK);
		}
		else {
			responseEntity=new ResponseEntity<Boolean>(value,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

}
