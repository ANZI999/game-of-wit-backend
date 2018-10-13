package com.myproduction.gameofwit.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproduction.gameofwit.model.Challenge;

@RequestMapping(value="/challenge")
@RestController
public class ChallengeController {
	
	@RequestMapping(value="/get/{id:[\\d]+}", method = RequestMethod.GET)
	public String get(@PathVariable Integer id) {
		return "Tere siin on: " + id;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String get() {
		return "Tere";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Challenge create(@RequestBody Challenge challenge) {
		return challenge;
	}
}
