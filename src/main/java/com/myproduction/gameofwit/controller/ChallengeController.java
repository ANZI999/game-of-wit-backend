package com.myproduction.gameofwit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproduction.gameofwit.model.Challenge;
import com.myproduction.gameofwit.repository.ChallengeService;

@RequestMapping(value="/challenge")
@RestController
public class ChallengeController {
	
	@Autowired
	ChallengeService challengeService;
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public Challenge getById(@PathVariable Long id) {
		Challenge challenge = challengeService.findById(id, true);
		return challenge;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public List<Challenge> getAll() {
		List<Challenge> allChallenges = challengeService.findAll();
		return allChallenges;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Challenge create(@RequestBody Challenge challenge) {
		challengeService.save(challenge);

		return challenge;
	}
}
