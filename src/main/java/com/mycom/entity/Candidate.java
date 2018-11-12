package com.mycom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;

import com.mycom.entity.validation.Date;
import com.mycom.entity.validation.Name;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="candidate")
public class Candidate implements Serializable {
	public static final String TABLE_NAME = "candidate";
	public static final String SALARY_COLUMN = "salary";
	public static final String BIRTHDAY_COLUMN = "birthday";
	public static final String SURNAME_COLUMN = "surname";
	public static final String NAME_COLUMN = "name";
	public static final String ID_COLUMN = "id";
	public static final String CANDIDATESTATE_COLUMN = "candidateState";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@DecimalMax("10000.0") @DecimalMin("200")
	@Column(name="salary")
	private double salary;
	
    @DateTimeFormat
    @Column(name="birthday")
	private DateTime birthday;
    
    @Name
    @Column(name="surname")
	private String surname;
    
    @Name
    @Column(name="name")
	private String name;
    
    @ManyToOne
    @JoinColumn(name = "candidateState")
	private CandidateState candidateState;
    
	@NotNull
	@ManyToMany
	@JoinTable(name = "candidatecompetence", joinColumns = @JoinColumn(name = "idCandidate"),
			   inverseJoinColumns = @JoinColumn(name = "skill"))
	private Set<Skill> skills;
	
	@OneToMany(mappedBy = "candidate")
	private Set<Interview> interviews;
	
	
	
	
	public Set<Interview> getInterviews() {
		if (this.interviews == null) {
			this.interviews = new HashSet<Interview>();
		}
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public Set<Skill> getSkills() {
		if (this.skills==null) {
			this.skills = new HashSet<Skill>();
		}
		return skills;
	}
	
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public DateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CandidateState getCandidateState() {
		return candidateState;
	}

	public void setCandidateState(CandidateState candidateState) {
		this.candidateState = candidateState;
	}
	
	
}
