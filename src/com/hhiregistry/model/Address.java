package com.hhiregistry.model;
// Generated 29-Jan-2011 07:49:27 by Hibernate Tools 3.2.4.GA


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
     private Set members = new HashSet(0);
     private Set members_1 = new HashSet(0);

    public Address() {
    }

	
    public Address(int addressId) {
        this.addressId = addressId;
    }
    public Address(int addressId, String addressline1, String addressline2, String addressline3, String createdBy, Date createdDate, Set members, Set members_1) {
       this.addressId = addressId;
       this.addressline1 = addressline1;
       this.addressline2 = addressline2;
       this.addressline3 = addressline3;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.members = members;
       this.members_1 = members_1;
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
    public Set getMembers() {
        return this.members;
    }
    
    public void setMembers(Set members) {
        this.members = members;
    }
    public Set getMembers_1() {
        return this.members_1;
    }
    
    public void setMembers_1(Set members_1) {
        this.members_1 = members_1;
    }




}


