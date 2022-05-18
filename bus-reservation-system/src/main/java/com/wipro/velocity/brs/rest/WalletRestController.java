package com.wipro.velocity.brs.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.Wallet;
import com.wipro.velocity.brs.model.WalletGet;
import com.wipro.velocity.brs.repository.UserRepository;
import com.wipro.velocity.brs.repository.WalletRepository;

@RestController
@RequestMapping(value="api/wallet")
@CrossOrigin(origins="http://localhost:4200")
public class WalletRestController {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private WalletRepository wrepo;
	
	@PostMapping("/create/{email}")
	public void createWallet(@RequestBody Wallet w, @PathVariable(value="email") String email) {
		List<Wallet> wallets;
//		System.out.println(w.getCardno()+w.getCardType()+w.getPin());
//		System.out.println(email);
		Customer cust = urepo.findByEmail(email);
		
		if(cust.getWallet()!=null) {
		wallets = cust.getWallet();
		}
		else {
			wallets = new ArrayList<Wallet>();
		}
		w.setCustomer(cust);
		wrepo.save(w);
		wallets.add(w);
		
		cust.setWallet(wallets);
		urepo.save(cust);
	}
	
	@GetMapping("get/{email}")
	public List<WalletGet> getWallet(@PathVariable String email ){
		System.out.println(email);
		
		Customer cust=urepo.findByEmail(email);
		
		return wrepo.getWallets(cust);
		
		}
	}

