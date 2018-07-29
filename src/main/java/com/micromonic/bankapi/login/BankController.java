package com.micromonic.bankapi.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String getBalance(@PathVariable Long id) {

		System.out.println("ID " + id);
		return bankService.getBalance(id);
	}

	@RequestMapping("/bank")
	public List<Customer> getBalance() {

		return bankService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customer")
	public String addCustomer(@RequestBody Customer customer) {

		return bankService.addCustomer(customer);
	}

	@RequestMapping("/bank/{accNo}/wrd/{amount}")
	public String withdrawAmt(@PathVariable Long accNo, @PathVariable int amount) {

		System.out.println("ID " + accNo);
		return bankService.getWithdrawn(accNo, amount);
	}

	@RequestMapping("/bank/{accNo}/depo/{amount}")
	public String depositAmt(@PathVariable Long accNo, @PathVariable int amount) {

		System.out.println("ID " + accNo);
		return bankService.setDeposite(accNo, amount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bank")
	public String depoAmt(@RequestParam Long id, @RequestParam int amt) {

		System.out.println("ID " + id);
		return bankService.setDeposite(id, amt);
	}

}
