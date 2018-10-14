package com.myproduction.gameofwit.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproduction.gameofwit.AWS;
import com.myproduction.gameofwit.model.Challenge;
import com.myproduction.gameofwit.model.ChallengeRepository;
import com.myproduction.gameofwit.model.ChallengeStructure;

@RequestMapping(value="/challenge")
@RestController
public class ChallengeController {
	
	@Autowired
	ChallengeRepository challengeRepository;
	
	@Autowired
	private AWS aws;
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public Challenge getById(@PathVariable Long id) {
		Challenge challenge = challengeRepository.findById(id).orElse(null);
		challenge.setStructure(aws.getDynamoDBMapper().load(ChallengeStructure.class, id));
		return challenge;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public List<Challenge> getAll() {
		Iterator<Challenge> iterator = challengeRepository.findAll().iterator();
		List<Challenge> allChallenges = new ArrayList<Challenge>();
		while(iterator.hasNext()) {
			Challenge challenge = iterator.next();
			allChallenges.add(challenge);
		}
		return allChallenges;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Challenge create(@RequestBody Challenge challenge) {
		challengeRepository.save(challenge);
		aws.getDynamoDBMapper().save(challenge.getStructure());
		
		return challenge;
	}
}
