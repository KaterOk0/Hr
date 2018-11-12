package com.mycom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.mycom.entity.validation.Date;
import org.springframework.format.annotation.DateTimeFormat;

import org.joda.time.DateTime;;

@Entity
@Table(name = "interview")
public class Interview {
	public static final String TABLE_NAME = "interview";
	public static final String ID_COLUMN = "id";
	public static final String FACTDATE_COLUMN = "factDate";
	public static final String PLANDATE_COLUMN = "planDate";
	public static final String IDVACANCY_COLUMN = "idVacancy";
	public static final String IDCANDIDATE_COLUMN = "idCandidate";
	public static final String NAME_CLOUMN = "name";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@DateTimeFormat
	@Column(name = "factDate")
	private DateTime factDate;
	
	@DateTimeFormat
	@Column(name = "planDate")
	private DateTime planDate;
	
	@ManyToOne
	@JoinColumn(name = "idVacancy")
	private Vacancy vacancy;
	
	@ManyToOne
	@JoinColumn(name = "idCandidate")
	private Candidate candidate;
	
	@Size(min=5)
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "interview")
	private FeedBack feedback;
	
	

	public FeedBack getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBack feedback) {
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getFactDate() {
		return factDate;
	}

	public void setFactDate(DateTime factDate) {
		this.factDate = factDate;
	}

	public DateTime getPlanDate() {
		return planDate;
	}

	public void setPlanDate(DateTime planDate) {
		this.planDate = planDate;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
