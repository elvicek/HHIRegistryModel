package com.aes.model;
// Generated Apr 14, 2016 4:36:50 PM by Hibernate Tools 3.5.0.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
public class Address  implements java.io.Serializable {


     private int addressId;
     private String addressline1;
     private String addressline2;
     private String addressline3;
     private String createdBy;
     private Date createdDate;
     private Set<Person> persons = new HashSet<Person>(0);
     private Set<Client> clients = new HashSet<Client>(0);

    public Address() {
    }

	
    public Address(int addressId) {
        this.addressId = addressId;
    }
    public Address(int addressId, String addressline1, String addressline2, String addressline3, String createdBy, Date createdDate, Set<Person> persons, Set<Client> clients) {
       this.addressId = addressId;
       this.addressline1 = addressline1;
       this.addressline2 = addressline2;
       this.addressline3 = addressline3;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.persons = persons;
       this.clients = clients;
    }
   
    public int getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    public String getAddressline1() {
        return this.addressline1;
    }
    
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }
    public String getAddressline2() {
        return this.addressline2;
    }
    
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }
    public String getAddressline3() {
        return this.addressline3;
    }
    
    public void setAddressline3(String addressline3) {
        this.addressline3 = addressline3;
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
    public Set<Person> getPersons() {
        return this.persons;
    }
    
    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
    public Set<Client> getClients() {
        return this.clients;
    }
    
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }




}


