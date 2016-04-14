package com.aes.data.domain;
// Generated Apr 14, 2016 5:59:27 PM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private int personId;
	private Address address;
	private String name;
	private String surname;
	private String title;
	private Date birthday;
	private Character sex;
	private String phone;
	private String workphone;
	private String cellphone;
	private String description;
	private String email;
	private String createdBy;
	private Date createdDate;
	private Set<User> users = new HashSet<User>(0);
	private Set<Client> clients = new HashSet<Client>(0);

	public Person() {
	}

	public Person(int personId, Address address, String email) {
		this.personId = personId;
		this.address = address;
		this.email = email;
	}

	public Person(int personId, Address address, String name, String surname, String title, Date birthday,
			Character sex, String phone, String workphone, String cellphone, String description, String email,
			String createdBy, Date createdDate, Set<User> users, Set<Client> clients) {
		this.personId = personId;
		this.address = address;
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.birthday = birthday;
		this.sex = sex;
		this.phone = phone;
		this.workphone = workphone;
		this.cellphone = cellphone;
		this.description = description;
		this.email = email;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.users = users;
		this.clients = clients;
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Character getSex() {
		return this.sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkphone() {
		return this.workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}