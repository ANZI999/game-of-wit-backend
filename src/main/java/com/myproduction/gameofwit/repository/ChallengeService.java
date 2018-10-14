package com.myproduction.gameofwit.repository;

import java.util.List;

import com.myproduction.gameofwit.model.Challenge;

public interface ChallengeService {
	public Challenge findById(Long id, boolean hasStructure);
	
	public List<Challenge> findAll();
	
	public void save(Challenge challenge);
}
