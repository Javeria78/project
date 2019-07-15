package com.lti.airline.model;



import javax.persistence.*;

import org.hibernate.annotations.*;


@
@Table(name="users")
public class Passenger {

	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Id
	@Column(name="id")
	private int id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
	
	}

	

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
	
}

	

