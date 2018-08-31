package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.Feedback;

public class FeedbackRepositoryList {

	private Map<Integer, Feedback> feedbackMap = new HashMap<>();
	private int feedbackIdGenerator = 1000;

	
	public List<Feedback> findAll() {
		return new ArrayList<>(feedbackMap.values());
	}

	
	public Feedback find(int id) {
		return feedbackMap.get(id);
	}

	
	public Feedback save(Feedback model) {
		if (find(model.getFeedbackId()) != null) {
			feedbackMap.put(model.getFeedbackId(), model);
			return model;
		}
		model.setFeedbackId(feedbackIdGenerator++);
		feedbackMap.put(model.getFeedbackId(), model);
		return model;
	}

	
	public Feedback delete(Feedback model) {
		return feedbackMap.remove(model.getFeedbackId());
	}

}
