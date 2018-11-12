package com.mycom.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feedbackstate")
public class FeedBackState {
	public static String TABLE_NAME = "feedbackstate";
	public static String NAME_COLUMN = "name";
	
	@Id
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "feedbackState")
	private Set<FeedBack> feedbacks;
	

	public Set<FeedBack> getFeedbacks() {
		if (this.feedbacks == null) {
			this.feedbacks = new HashSet<FeedBack>();
		}
		return feedbacks;
	}

	public void setFeedbacks(Set<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
