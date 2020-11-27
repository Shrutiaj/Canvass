package com.appapi.canvassapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@Column(name="userName")
	String userName;
	
	@Column(name="password")
	String password;
	
	@Column(name="custID")
	int custID;
	
	@Column(name="roleID")
	int roleID;

	public User(String userName, String password, int custID, int roleID) {
		super();
		this.userName = userName;
		this.password = password;
		this.custID = custID;
		this.roleID = roleID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
}
