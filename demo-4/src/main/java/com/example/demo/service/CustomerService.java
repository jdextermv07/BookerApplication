package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Feedback;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.FeedbackRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private FeedbackService feedbackService;

	
	
	public CustomerService(CustomerRepository customerRepository, FeedbackService feedbackService) {
		super();
		this.customerRepository = customerRepository;
		this.feedbackService = feedbackService;
	}

	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}
	
	public Iterable<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	@Transactional
	public Customer saveCustomer(Customer customer) {
		
		for (Feedback value : customer.getFeedbackList()) {
			value.setCustomer(customer);
			feedbackService.saveFeedback(value);
		}
		return customerRepository.save(customer);
	}
	
	
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
//	public Customer findCustomerByFirstName(Customer customer) {
//		return customerRepository.find
//	}
}
