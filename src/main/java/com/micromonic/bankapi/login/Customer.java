package com.micromonic.bankapi.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
	@Id 
	private Long id;
	
	private String name;
	 
	private String password;
	
	 
	private String emailid;
	
	 
	private int balance;
	
	
	public Customer() {
		
	}
	
	public Customer(Long id, String name, String password, String emailid, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emailid = emailid;
		this.balance = balance;
	}
	public Customer(String name, String password, String emailid, int balance) {
		super();
	 
		this.name = name;
		this.password = password;
		this.emailid = emailid;
		this.balance = balance;
	}
 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
