package com.aes.data.domain;
// Generated Apr 14, 2016 5:59:27 PM by Hibernate Tools 3.5.0.Final

/**
 * Dbsettings generated by hbm2java
 */
public class Dbsettings implements java.io.Serializable {

	private int id;
	private Integer type;
	private String description;

	public Dbsettings() {
	}

	public Dbsettings(int id) {
		this.id = id;
	}

	public Dbsettings(int id, Integer type, String description) {
		this.id = id;
		this.type = type;
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}