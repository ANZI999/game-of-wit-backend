package com.myproduction.gameofwit.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproduction.gameofwit.AWS;
import com.myproduction.gameofwit.model.Challenge;
import com.myproduction.gameofwit.model.ChallengeStructure;

@Component
public class ChallengeServiceImplementation implements ChallengeService {
	
	@Autowired
	private AWS aws;
	
	@Autowired
	private ChallengeRepository crudRepository;
	
	@Override
	public Challenge findById(Long id, boolean hasStructure) {
		Challenge challenge = crudRepository.findById(id).orElse(null);
		if(hasStructure && challenge != null) {
			challenge.setStructure(
					aws.getDynamoDBMapper().load(ChallengeStructure.class, id));
		}		
		return challenge;
	}

	@Override
	public List<Challenge> findAll() {
		Iterator<Challenge> iterator = crudRepository.findAll().iterator();
		List<Challenge> allChallenges = new ArrayList<Challenge>();
		while(iterator.hasNext()) {
			allChallenges.add(iterator.next());
		}
		return allChallenges;
	}

	@Override
	public void save(Challenge challenge) {
		crudRepository.save(challenge);
		aws.getDynamoDBMapper().save(challenge.getStructure());
	}

}
