package com.aes.data.domain;
// Generated Apr 15, 2016 9:48:50 AM by Hibernate Tools 3.5.0.Final

import java.util.Date;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private String username;
	private Role role;
	private Person person;
	private String password;
	private String createdBy;
	private Date createdDate;

	public User() {
	}

	public User(String username, Role role, Person person, String password) {
		this.username = username;
		this.role = role;
		this.person = person;
		this.password = password;
	}

	public User(String username, Role role, Person person, String password, String createdBy, Date createdDate) {
		this.username = username;
		this.role = role;
		this.person = person;
		this.password = password;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
