package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerRepository;

@Service
public class MyService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public String getMessage() {
		customerRepository.save(new Customer("RABBAH", "Mahmoud"));
		customerRepository.save(new Customer("Ahmed", "Najib"));
		return "Hello Spring Boot from my Service";
	}

	public String helloFrom(long customerId) {
		Customer customer = customerRepository.findById(customerId);
		return "Hello from " + customer.toString();
	}
}
