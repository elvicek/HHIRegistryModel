package com.aes.data.domain;
// Generated Apr 15, 2016 4:26:55 PM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Survey generated by hbm2java
 */
public class Survey implements java.io.Serializable {

	private int surveyId;
	private User user;
	private String surveyName;
	private String surveyType;
	private String workSummary;
	private Date surveyRequestedDate;
	private Date surveyDate;
	private String createdBy;
	private Date createdDate;
	private String status;
	private Set<SurveyReadings> surveyReadingses = new HashSet<SurveyReadings>(0);
	private Set<Client> clients = new HashSet<Client>(0);

	public Survey() {
	}

	public Survey(int surveyId, User user) {
		this.surveyId = surveyId;
		this.user = user;
	}

	public Survey(int surveyId, User user, String surveyName, String surveyType, String workSummary,
			Date surveyRequestedDate, Date surveyDate, String createdBy, Date createdDate, String status,
			Set<SurveyReadings> surveyReadingses, Set<Client> clients) {
		this.surveyId = surveyId;
		this.user = user;
		this.surveyName = surveyName;
		this.surveyType = surveyType;
		this.workSummary = workSummary;
		this.surveyRequestedDate = surveyRequestedDate;
		this.surveyDate = surveyDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.status = status;
		this.surveyReadingses = surveyReadingses;
		this.clients = clients;
	}

	public int getSurveyId() {
		return this.surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSurveyName() {
		return this.surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyType() {
		return this.surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public String getWorkSummary() {
		return this.workSummary;
	}

	public void setWorkSummary(String workSummary) {
		this.workSummary = workSummary;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<SurveyReadings> getSurveyReadingses() {
		return this.surveyReadingses;
	}

	public void setSurveyReadingses(Set<SurveyReadings> surveyReadingses) {
		this.surveyReadingses = surveyReadingses;
	}

	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Date getSurveyRequestedDate() {
		return surveyRequestedDate;
	}

	public void setSurveyRequestedDate(Date surveyRequestedDate) {
		this.surveyRequestedDate = surveyRequestedDate;
	}

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

}
