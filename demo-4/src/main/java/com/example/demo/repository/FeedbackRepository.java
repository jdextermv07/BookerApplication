package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;
import com.example.demo.model.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}
