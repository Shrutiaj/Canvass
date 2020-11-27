package com.appapi.canvassapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appapi.canvassapi.models.Customer;
import com.appapi.canvassapi.repositories.CustomerRepository;

@Service
public class CustomerDAO {
	@Autowired
	CustomerRepository customerRepository;
	
	/* save a customer */
	public Customer save(Customer cust) {
		return customerRepository.save(cust);
	}
	
	/* search all customers */
	public List<Customer> findAll(){
		return (List<Customer>)customerRepository.findAll();
	}
	
	/* get a customer */
	public Customer getCustomerById(Long custID) {
		return customerRepository.findCustomerByCustomerId(custID);
	}
	
	/* delete a customer */
	public void delete(Customer cust) {
		customerRepository.delete(cust);
	}

}
