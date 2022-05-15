package com.wipro.velocity.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.velocity.brs.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByEmail(String email);


}
