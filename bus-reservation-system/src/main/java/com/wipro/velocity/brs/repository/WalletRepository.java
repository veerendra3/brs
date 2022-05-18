package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.Wallet;
import com.wipro.velocity.brs.model.WalletGet;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
		
	@Query("SELECT new com.wipro.velocity.brs.model.WalletGet(w.cardType,w.cardno,w.pin,w.validity)"
			+ "FROM Wallet w where w.customer= ?1")
	List<WalletGet> getWallets(Customer cust);
	
}
