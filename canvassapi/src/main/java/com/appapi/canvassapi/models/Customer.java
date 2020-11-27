package com.appapi.canvassapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custID")
	int custID;
	
	@Column(name = "custName")
	String custName;
	
	@Column(name = "custDesc")
	String custDesc;
		
	public Customer(int custID, String custName, String custDesc) {
		super();
		this.custID = custID;
		this.custName = custName;
		this.custDesc = custDesc;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustDesc() {
		return custDesc;
	}

	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}

}
