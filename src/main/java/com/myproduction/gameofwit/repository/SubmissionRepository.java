package com.myproduction.gameofwit.repository;

import org.springframework.data.repository.CrudRepository;

import com.myproduction.gameofwit.model.Submission;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

}
