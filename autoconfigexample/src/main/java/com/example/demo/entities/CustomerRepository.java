package com.example.demo.entities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
    Customer findOneByfirstName(String firstName);

	Customer findById(long id);
}
