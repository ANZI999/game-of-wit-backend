package com.myproduction.gameofwit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproduction.gameofwit.Response;
import com.myproduction.gameofwit.model.Challenge;
import com.myproduction.gameofwit.repository.ChallengeService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping(value="/challenge")
@RestController
public class ChallengeController {
	
	@Autowired
	ChallengeService challengeService;
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public Response getById(@PathVariable Long id) {
		Challenge challenge = challengeService.findById(id, true);
		
		Response response = new Response();
		response.setData(challenge);
		return response;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public Response getAll() {
		List<Challenge> allChallenges = challengeService.findAll();
		
		Response response = new Response();
		response.setData(allChallenges);
		return response;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Response create(@RequestBody Challenge challenge) {
		challengeService.save(challenge);

		Response response = new Response();
		response.setData("success");
		return response;
	}
}
