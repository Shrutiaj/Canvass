package com.appapi.canvassapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name = "userName", referencedColumnName = "userName", insertable = false, updatable = false)
	private UserDetail userDetail;
	
	public User() { }

	public User(String userName, String password, int custID, int roleID, UserDetail userDetail) {
		super();
		this.userName = userName;
		this.password = password;
		this.custID = custID;
		this.roleID = roleID;
		this.userDetail = userDetail;
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

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
}
