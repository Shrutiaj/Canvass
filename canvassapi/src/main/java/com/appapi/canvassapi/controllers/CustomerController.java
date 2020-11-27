package com.appapi.canvassapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appapi.canvassapi.dao.CustomerDAO;
import com.appapi.canvassapi.models.Customer;

@RestController
@RequestMapping("/Customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers(){
		return customerDAO.findAll();
	}
	
	@GetMapping("/getByCustomerID")
	public Customer getCustomerByID(Long custID){
		return customerDAO.getCustomerById(custID);
	}
	
	@PostMapping("/createCustomer")
	public Customer createCustomer(@Valid @RequestBody Customer cust) {
		return customerDAO.save(cust);
	}
}
