package com.aes.data.domain;
// Generated Apr 14, 2016 5:59:27 PM by Hibernate Tools 3.5.0.Final

import java.util.Date;

/**
 * SurveyReadings generated by hbm2java
 */
public class SurveyReadings implements java.io.Serializable {

	private int readingId;
	private int surveyId;
	private String location;
	private String readingType;
	private String unit;
	private String value;
	private String description;
	private String createdBy;
	private Date createdDate;

	public SurveyReadings() {
	}

	public SurveyReadings(int readingId, int surveyId) {
		this.readingId = readingId;
		this.surveyId = surveyId;
	}

	public SurveyReadings(int readingId, int surveyId, String location, String readingType, String unit, String value,
			String description, String createdBy, Date createdDate) {
		this.readingId = readingId;
		this.surveyId = surveyId;
		this.location = location;
		this.readingType = readingType;
		this.unit = unit;
		this.value = value;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public int getReadingId() {
		return this.readingId;
	}

	public void setReadingId(int readingId) {
		this.readingId = readingId;
	}

	public int getSurveyId() {
		return this.surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReadingType() {
		return this.readingType;
	}

	public void setReadingType(String readingType) {
		this.readingType = readingType;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
