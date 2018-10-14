package com.myproduction.gameofwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproduction.gameofwit.model.Challenge;
import com.myproduction.gameofwit.model.Submission;
import com.myproduction.gameofwit.repository.ChallengeService;
import com.myproduction.gameofwit.repository.SubmissionService;

@RequestMapping(value="/submission")
@RestController
public class SubmissionController {
	
	@Autowired
	ChallengeService challengeService;
	
	@Autowired
	SubmissionService submissionService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(@RequestBody Submission submission) {
		Challenge challenge = challengeService.findById(submission.getChallengeId(), true);
		
		if(challenge.isValid(submission)) {
			submissionService.save(submission);
		}
		
		return "okay";
	}
}
