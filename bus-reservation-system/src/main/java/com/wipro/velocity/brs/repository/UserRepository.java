package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.CustomerAddress;

public interface UserRepository extends CrudRepository<Customer, Long>{
	
	public Customer findByEmail(String email);
	
	@Query("SELECT new com.wipro.velocity.brs.model.CustomerAddress(c.id,c.email,c.fname,c.lname,"
            + "c.mobile,c.password,c.gender,a.street,a.pincode,a.city,a.state) "
            + "FROM Customer c INNER JOIN c.address a")
	 List<CustomerAddress> fetchCustomerInnerJoin();
	
	@Query("SELECT new com.wipro.velocity.brs.model.CustomerAddress(c.id,c.email,c.fname,c.lname,"
            + "c.mobile,c.password,c.gender,a.street,a.pincode,a.city,a.state) "
            + "FROM Customer c INNER JOIN c.address a where c.email=?1")
	 CustomerAddress getCustomer(String email);
	
	@Query("SELECT new com.wipro.velocity.brs.model.CustomerAddress(c.id,c.email,c.fname,c.lname,"
            + "c.mobile,c.password,c.gender,a.street,a.pincode,a.city,a.state) "
            + "FROM Customer c INNER JOIN c.address a")
	 List<CustomerAddress> getCustomers();
	
	@Query(value="SELECT COUNT(bookid) FROM bookings WHERE customer_id=?1",
			nativeQuery=true)
	Long getBookingsCount(Long custId);
	
	
	}