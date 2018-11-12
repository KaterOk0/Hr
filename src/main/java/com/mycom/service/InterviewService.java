package com.mycom.service;

import com.mycom.entity.Interview;

import java.util.List;

public interface InterviewService {
    public List<Interview> findAll();
    public List<Interview> SortByDateFact();
    public List<Interview> SortByDatePlan();
    public List<Interview> FindByCandidate(long candidate_id);
    public Interview FindById(long id);
    public void insert(Interview interview);
    public void update(Interview interview);
    public void delete(long interview_id);
}
