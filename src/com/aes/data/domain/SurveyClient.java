package com.aes.data.domain;
// Generated Apr 14, 2016 5:59:27 PM by Hibernate Tools 3.5.0.Final

/**
 * SurveyClient generated by hbm2java
 */
public class SurveyClient implements java.io.Serializable {

	private SurveyClientId id;
	private Client client;

	public SurveyClient() {
	}

	public SurveyClient(SurveyClientId id, Client client) {
		this.id = id;
		this.client = client;
	}

	public SurveyClientId getId() {
		return this.id;
	}

	public void setId(SurveyClientId id) {
		this.id = id;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
