package com.project.orderMgmt.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Driver", schema = "SOURAV")
public class Driver {

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Id
	@Column(name="Phone")
	private long phn;
	
	@Column(name="license")
	private long license;
	
	@Column(name="status")
	private String status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhn() {
		return phn;
	}
	public void setPhn(long phn) {
		this.phn = phn;
	}
	public long getLicense() {
		return license;
	}
	public void setLicense(long license) {
		this.license = license;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
