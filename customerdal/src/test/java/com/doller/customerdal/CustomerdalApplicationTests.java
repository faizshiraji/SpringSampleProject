package com.doller.customerdal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.doller.customerdal.entities.Customer;
import com.doller.customerdal.repos.CustomerRepository;

@SpringBootTest
class CustomerdalApplicationTests {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setName("Abdul Kader");
		customer.setCemail("abdul.kader@gmail.com");

		customerRepository.save(customer);
	}
	
	@Test
	public void testFindCustomerById() {
		Customer customer = customerRepository.findById(1l).get();
		System.out.println(customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerRepository.findById(1l).get();
		customer.setCemail("abdulkader@gmail.com");
		
		customerRepository.save(customer);
	}
	
	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer();
		customer.setId(1l);
		customerRepository.delete(customer);
	}
	
}
