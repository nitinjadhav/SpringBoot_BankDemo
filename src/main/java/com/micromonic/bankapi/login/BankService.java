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

	public String getBalance(Long id) {
		Optional<Customer> customer = bankRepository.findById(id);	
		
		return " Account no. "+ customer.get().getId() + " balance is Rs."+ customer.get().getBalance()+" !! ";
				//bankRepository.findById(id).get().getBalance();
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
		} catch (Exception e) {
			return "Error";
		}

	}

	public String getWithdrawn(Long id, int amount) {

		Optional<Customer> customer = bankRepository.findById(id);
		String msg = "";

		if ((customer.get().getBalance() - amount) > 0) {

			int tempBalance = customer.get().getBalance() - amount;

			customer.get().setBalance(tempBalance);

			bankRepository.save(customer.get());
			return " Rs." + amount + " is withdrawn from Account No.: " + id + " Successfully..!! \n "+ "Balance now Rs."+ tempBalance;

		} else {
			return " Balance amount Rs."+ customer.get().getBalance() +" of Account no. " + id + "is too low..! ";
		}

	}

	public String setDeposite(Long id, int amount) {

		Optional<Customer> customer = bankRepository.findById(id);
		int temp = customer.get().getBalance() + amount;
		customer.get().setBalance(temp);
		bankRepository.save(customer.get());

		return " Rs." + amount + " is Deposited to Account No.: " + id + " Successfully..!! \n Now Balance is Rs."+ temp;

	}

}
