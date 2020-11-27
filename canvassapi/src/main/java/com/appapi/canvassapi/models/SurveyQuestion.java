package com.appapi.canvassapi.models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.appapi.canvassapi.models.Survey;

enum ResponseType{
	radio,
	checkBox,
	textbox
}

@Entity
@Table(name="SurveyQuestions")
public class SurveyQuestion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="questionID")
	int questionID;
	
	@Column(name="surveyID")
	int surveyID;
	
	@Column(name="question")
	String question;
	
	@Enumerated
	@Column(name="responseType")
	ResponseType responseType;
	
	@Column(name="optionValues")
	String optionValues;
	
	@Column(name="createdDate")
	Timestamp createdDate;
	
	@Column(name="createdBy")
	String createdBy;
	
	@Column(name="lastModified")
	Timestamp lastModified;
	
	@Column(name="modifiedBy")
	String modifiedBy;
	
	@ManyToOne
	@JoinColumn (name="surveyID",insertable = false, updatable = false)
	@JsonBackReference
	private Survey survey;

	public SurveyQuestion(int questionID, int surveyID, String question, ResponseType responseType, String optionValues,
			Timestamp createdDate, String createdBy, Timestamp lastModified, String modifiedBy) {
		super();
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.question = question;
		this.responseType = responseType;
		this.optionValues = optionValues;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.modifiedBy = modifiedBy;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ResponseType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	public String getOptionValues() {
		return optionValues;
	}

	public void setOptionValues(String optionValues) {
		this.optionValues = optionValues;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
