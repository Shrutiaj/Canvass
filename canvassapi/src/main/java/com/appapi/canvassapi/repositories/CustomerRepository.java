package com.appapi.canvassapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appapi.canvassapi.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findCustomerByCustID(Long custID);
}
