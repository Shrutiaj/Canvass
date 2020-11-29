package com.appapi.canvassapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.appapi.canvassapi.models.Survey;
import com.appapi.canvassapi.models.SurveyQuestion;
import com.appapi.canvassapi.models.User;

@Entity
@Table(name="SubmittedSurveys")
public class SubmittedSurvey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int responseID;
	
	@Column(name="questionID")
	int questionID;
	
	@Column(name="surveyID")
	int surveyID;
	
	@Column(name="userName")
	String userName;
	
	@Column(name="response")
	String response;
	
	@Column(name="createdBy")
	String createdBy;
	
	@ManyToOne
	@JoinColumn (name="surveyID",referencedColumnName="surveyID",insertable = false, updatable = false)
	@JsonBackReference(value="survey")
	private Survey survey;
	
	@ManyToOne(optional = false)
	@JoinColumn (name="questionID",referencedColumnName="questionID",insertable = false, updatable = false)
	@JsonBackReference(value="surveyQuestion")
	private SurveyQuestion surveyQuestion;
	
	@ManyToOne
	@JoinColumn (name="username",insertable = false, updatable = false)
	@JsonBackReference(value="user")
	private User user;

	public SubmittedSurvey() { }
	
	public SubmittedSurvey(int responseID, int questionID, int surveyID, String username, String response,
			String createdBy) {
		super();
		this.responseID = responseID;
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.userName = username;
		this.response = response;
		this.createdBy = createdBy;
	}

	public int getResponseID() {
		return responseID;
	}

	public void setResponseID(int responseID) {
		this.responseID = responseID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
