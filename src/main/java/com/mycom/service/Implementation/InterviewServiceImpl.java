package com.mycom.service.Implementation;

import com.mycom.dao.InterviewDao;
import com.mycom.entity.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewDao interviewDao;

    @Override
    public List<Interview> findAll(){
        return interviewDao.findAll();
    }
    @Override
    public List<Interview> SortByDateFact(){
        return interviewDao.SortByDateFact();
    }
    @Override
    public List<Interview> SortByDatePlan(){
        return interviewDao.SortByDatePlan();
    }
    @Override
    public List<Interview> FindByCandidate(long candidate_id){
        return interviewDao.FindByCandidate(candidate_id);
    }
    @Override
    public Interview FindById(long id){
        return interviewDao.FindById(id);
    }
    @Override
    public void insert(Interview interview){
        interviewDao.insert(interview);
    }
    @Override
    public void update(Interview interview){
        interviewDao.update(interview);
    }
    @Override
    public void delete(long interview_id){
        interviewDao.delete(interview_id);
    }
}
