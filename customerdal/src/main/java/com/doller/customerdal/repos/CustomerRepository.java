package com.doller.customerdal.repos;

import org.springframework.data.repository.CrudRepository;

import com.doller.customerdal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
