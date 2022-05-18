package com.wipro.velocity.brs.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.brs.model.Admin;
import com.wipro.velocity.brs.model.Customer;

public interface AdminRepository extends CrudRepository<Admin, Long> {
	
	public Admin findByEmail(String email);

}
