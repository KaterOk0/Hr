package com.mycom.dao.Implementation;


import com.mycom.dao.InterviewDao;
import com.mycom.entity.Interview;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class InterviewDaoImpl implements InterviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Interview> findAll(){
        return sessionFactory.getCurrentSession().createQuery("from Interview").list();
    }
    @Override
    public List<Interview> SortByDateFact(){
        return sessionFactory.getCurrentSession().createQuery("from Interview order by planDate").list();
    }
    public List<Interview> SortByDatePlan(){
        return sessionFactory.getCurrentSession().createQuery("from Interview order by factDate").list();
    }
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public List<Interview> FindByCandidate(long candidate_id){
        return sessionFactory.getCurrentSession().createQuery("from Interview where idCandidate=" + candidate_id).list();

    }


    @Override
    public Interview FindById(long id){
        return (Interview)sessionFactory.getCurrentSession().get(Interview.class, id);
    }
    @Override
    public void insert(Interview interview){
        sessionFactory.getCurrentSession().saveOrUpdate(interview);
    }
    @Override
    public void update(Interview interview){
        sessionFactory.getCurrentSession().update(interview);
    }

    @Override
    public void delete(long interview_id){
        Interview interview = (Interview) sessionFactory.getCurrentSession().load(
                Interview.class, interview_id);
        if (null != interview) {
            this.sessionFactory.getCurrentSession().delete(interview);
        }
    }
}
