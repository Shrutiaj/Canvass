package com.appapi.canvassapi.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.appapi.canvassapi.models.Customer;
import com.appapi.canvassapi.models.SurveyQuestion;

@Entity
@Table(name="Surveys")
public class Survey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int surveyID;
	
	@Column(name="surveyName")
	String surveyName;
	
	@Column(name="createdDate")
	Timestamp createdDate;
	
	@Column(name="lastModified")
	Timestamp lastModified;
	
	@Column(name="custID")
	int custID;
	
	@Column(name="createdBy")
	String createdBy;
	
	@Column(name="modifiedBy")
	String modifiedBy;
	
	@Column(name="description")
	String description;
	
	@ManyToOne
	@JoinColumn (name="custID",insertable = false, updatable = false)
	@JsonBackReference
	private Customer customer;
	
	@OneToMany(mappedBy = "survey")
    private Set<SurveyQuestion> surveyQuestions = new HashSet<SurveyQuestion>();

	public Survey(int surveyID, String surveyName, Timestamp createdDate, Timestamp lastModified, int custID,
			String createdBy, String modifiedBy, String description) {
		super();
		this.surveyID = surveyID;
		this.surveyName = surveyName;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		this.custID = custID;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.description = description;
	}

	public int getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}

	public void setSurveyQuestions(Set<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
	
}
