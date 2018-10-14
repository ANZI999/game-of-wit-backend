package com.myproduction.gameofwit.repository;

import org.springframework.data.repository.CrudRepository;

import com.myproduction.gameofwit.model.Challenge;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

}
