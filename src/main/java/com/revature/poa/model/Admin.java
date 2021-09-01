package com.revature.poa.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="poa.admin")
public class Admin {
	
	@Id
	private String adminUserName;
	private String adminPassword;
	private Date lastLoggedInTime;
}
