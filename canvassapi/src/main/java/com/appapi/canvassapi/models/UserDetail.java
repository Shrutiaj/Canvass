package com.appapi.canvassapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UserDetails")
public class UserDetail {

	@Id
	String userName;
	
	@Column(name="fullName")
	String fullName;
	
	@Column(name="phoneNumber")
	String phoneNumber;
	
	@Column(name="userSummary")
	String userSummary;
	
	public UserDetail() { }
	
	public UserDetail(String userName, String fullName, String phoneNumber, String userSummary) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.userSummary = userSummary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
