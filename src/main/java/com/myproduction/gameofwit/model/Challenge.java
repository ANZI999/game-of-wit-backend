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
import javax.persistence.Transient;

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

	@Transient
	@JsonProperty("parts")
	private List<ChallengePart> parts;
	
	public Challenge() {
		
	}
	
	public Long getId() {
		return id;
	}
	
    public Date getCreated() { 
		return created; 
	}
	
    @JsonIgnore 
    public ChallengeStructure getStructure() { 
		return new ChallengeStructure(id, parts); 
	}
    
    public Long getUserId() { 
		return userId; 
	}
	
	public void setStructure(ChallengeStructure structure) {
		this.parts = structure.getParts();
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUserId(Long userId) { 
		this.userId = userId; 
	}
	
	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@Override
	public String toString() {
		StringBuilder answer = new StringBuilder();
		answer.append(userId + ", " + name +"\n");
		answer.append("[");
		for(int i = 0; i < parts.size(); i++) {
			if(i != 0) {
				answer.append(", ");
			}
			answer.append(parts.get(i));
		}
		answer.append("]");
		return answer.toString();
	}
}
