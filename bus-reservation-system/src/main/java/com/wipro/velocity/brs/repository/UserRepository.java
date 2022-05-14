package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.CustomerAddress;

public interface UserRepository extends CrudRepository<Customer, Long>{
	
	Customer findByEmail(String email);
	}