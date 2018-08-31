package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;

@Service
public class FeedbackService {

	private FeedbackRepository feedbackRepository;

	public FeedbackService(FeedbackRepository feedbackRepository) {
		super();
		this.feedbackRepository = feedbackRepository;
	}
	
	public Iterable<Feedback> findAll(){
		return feedbackRepository.findAll();
	}
	
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
	
}
