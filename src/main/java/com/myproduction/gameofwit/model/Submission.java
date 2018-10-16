package com.myproduction.gameofwit.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.util.SerializationUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "submission", schema = "data")
public class Submission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "user_id")
	@JsonProperty("userId")
	private Long userId;
	
	@Column(name = "challenge_id")
	@JsonProperty("challengeId")
	private Long challengeId;
	
	@Column(name = "created")
	@JsonProperty("created")
	private Date created;
	
	@Column(name = "structure")
	@JsonProperty("structure")
	private byte[] structureAsBytes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(Long challengeId) {
		this.challengeId = challengeId;
	}	

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@JsonIgnore
	public byte[] getStructureAsBytes() {
		return structureAsBytes;
	}

	public List<String> getStructure() {
		return (List<String>) SerializationUtils.deserialize(structureAsBytes);
	}

	public void setStructure(List<String> structure) {
		this.structureAsBytes = SerializationUtils.serialize(structure);
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}	
}
