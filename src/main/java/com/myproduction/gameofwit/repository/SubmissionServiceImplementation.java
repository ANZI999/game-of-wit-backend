package com.myproduction.gameofwit.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproduction.gameofwit.model.Submission;

@Component
public class SubmissionServiceImplementation implements SubmissionService {
	
	@Autowired
	private SubmissionRepository crudRepository;

	@Override
	public void save(Submission submission) {
		crudRepository.save(submission);
	}

}
