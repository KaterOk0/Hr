package com.mycom.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "candidatestate")
public class CandidateState implements Serializable{
	public static final String TABLE_NAME = "candidatestate";
	public static final String NAME_COLUMN = "name";
	
	@Id
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateState")
	private Set<Candidate> candidates;

	public Set<Candidate> getCandidates() {
		if (this.candidates == null) {
			this.candidates = new HashSet<Candidate>();
		}
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
