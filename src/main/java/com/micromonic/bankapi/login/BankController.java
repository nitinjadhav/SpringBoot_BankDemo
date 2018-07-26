package com.micromonic.bankapi.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
public class BankController {

	@Autowired
	BankService bankService;
	

	@RequestMapping("/hi")
	private String Hello() {
		return "Welcome";
	}

	@RequestMapping("/bank/{id}")
	public Optional<Customer> getBalance(@PathVariable Long id) {

		System.out.println("ID " + id);
		return bankService.getBalance(id);
	}

	@RequestMapping("/bank")
	public List<Customer> getBalance() {

		return bankService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customer")
	public String addTopic(@RequestBody Customer customer) {

		return bankService.addCustomer(customer);
	}
}
