package com.appapi.canvassapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="UserDetails")
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int username;
	
	@Column(name="fullName")
	String fullName;
	
	@Column(name="phoneNumber")
	String phoneNumber;
	
	@Column(name="userSummary")
	String userSummary;

	@OneToOne
	@JoinColumn(name = "userName", referencedColumnName = "userName", insertable = false, updatable = false)
	@JsonBackReference(value = "user")
	private User user;
	
	public UserDetail(int username, String fullName, String phoneNumber, String userSummary) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.userSummary = userSummary;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserSummary() {
		return userSummary;
	}

	public void setUserSummary(String userSummary) {
		this.userSummary = userSummary;
	}
	
}
