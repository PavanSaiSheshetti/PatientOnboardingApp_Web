package com.revature.poa.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.poa.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
 public Admin findByAdminUserNameAndAdminPassword(String adminUserName,String adminPassword);
}
