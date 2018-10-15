package com.myproduction.gameofwit.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.util.SerializationUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "challenge", schema = "data")
public class Challenge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "user_id")
	@JsonProperty("userId")
	private Long userId;
	
	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "created")
	@JsonProperty("created")
	private Date created;

	@Column(name = "structure")
	@JsonProperty("structure")
	private byte[] structureAsBytes;
	
	public Challenge() {
		
	}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<ChallengeElement> getStructure() {
		return (List<ChallengeElement>) SerializationUtils.deserialize(structureAsBytes);
	}

	public void setStructure(List<ChallengeElement> structure) {
		this.structureAsBytes = SerializationUtils.serialize(structure);
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public boolean isValid(Submission submission) {
		Iterator<String> spIterator = submission.getStructure().iterator();
		Iterator<ChallengeElement> cpIterator = this.getStructure().iterator();
		
		while(cpIterator.hasNext()) {
			ChallengeElement challengePart = cpIterator.next();
			if(challengePart.getIsFillable() && 
					(!spIterator.hasNext() || 
							!challengePart.isMatch(spIterator.next()))) {
				return false;
			}
		}
		
		if(spIterator.hasNext()) {
			return false;
		}
		
		return true;
	}
}
