package com.mycom.dao.Impl;

import java.util.List;

import com.mycom.dao.FeedBackDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.entity.FeedBack;

@Repository
public class FeedBackDaoImpl implements FeedBackDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<FeedBack> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from FeedBack").list();
	}

	@Override
	public List<FeedBack> findByInterviewer(long interviewer_id) {
		
		return null;
	}

	@Override
	public List<FeedBack> findByState(String feedbackState) {
		return null;
	}

	@Override
	public List<FeedBack> sort(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeedBack findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(FeedBack feedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FeedBack feedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long feedback_id) {
		// TODO Auto-generated method stub
		
	}

}
