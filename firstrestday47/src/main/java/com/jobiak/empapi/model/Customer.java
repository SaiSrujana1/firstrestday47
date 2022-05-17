package com.jobiak.empapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Long cusid;
	private String name;

	private double balance;
	
	public Customer() {
		
	}

	public Long getCusid() {
		return cusid;
	}

	public void setCusid(Long cusid) {
		this.cusid = cusid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [cusid=" + cusid + ", name=" + name + ", balance=" + balance + "]";
	}

	
}