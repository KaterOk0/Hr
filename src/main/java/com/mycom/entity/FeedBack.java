package com.mycom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "interviewfeedback")
public class FeedBack implements Serializable{
	public static final String TABLE_NAME = "interviewfeedback";
	public static final String REASON_COLUMN = "reason";
	public static final String FEEDBACKSTATE_COLUMN = "feedbackState";
	public static final String IDINTERVIEWER_COLUMN = "idInterviewer";
	public static final String IDINTERVIEW_COLUMN = "idInterview";
	public static final String ID_COLUMN = "id";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Size(min=1)
	@Column(name = "reason")
	private String reason;
	
	@ManyToOne
	@JoinColumn(name = "name")
	private FeedBackState feedbackState;
	
	@ManyToOne
	@JoinColumn(name = "idInterviewer")
	private User interviewer;
	
	@OneToOne
	@JoinColumn(name = "idInterview")
	private Interview interview;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public FeedBackState getFeedbackState() {
		return feedbackState;
	}

	public void setFeedbackState(FeedBackState feedbackState) {
		this.feedbackState = feedbackState;
	}

	public User getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(User interviewer) {
		this.interviewer = interviewer;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	
	
}
