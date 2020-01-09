package com.cts.sales.service.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class CustomerFeign {

	
	private Long customerId;
	
	
	private String email;
	
	private String firstName;
	

	private String lastName;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	

}
