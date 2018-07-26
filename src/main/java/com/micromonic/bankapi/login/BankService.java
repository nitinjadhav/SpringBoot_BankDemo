package com.micromonic.bankapi.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class BankService {
	
	@Autowired
	private BankRepository bankRepository;

	public Optional<Customer> getBalance(Long id) { 
		return bankRepository.findById(id);
	}

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		List<Customer> customer = new ArrayList<>();
		bankRepository.findAll().forEach(customer::add);
		return customer;
		
	}

	public String addCustomer(Customer customer) {
		try { 
			System.out.println(customer.getName());
			System.out.println(customer.getEmailid());
			System.out.println(customer.getPassword());
			System.out.println(customer.getBalance());
			bankRepository.save(customer);
			
			return "Done";
		}catch (Exception e) {
			return "Error";
		}
		
	}
	
	

}
