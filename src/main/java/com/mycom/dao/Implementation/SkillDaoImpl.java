package com.mycom.dao.Impl;

import java.util.List;

import com.mycom.dao.SkillDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.entity.Candidate;
import com.mycom.entity.Skill;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Skill> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Skill").list();
	}

	@Override
	public void insert(Skill skill) {
		sessionFactory.getCurrentSession().saveOrUpdate(skill);
		
	}

	@Override
	public void delete(String name) {
		Skill skill = (Skill) sessionFactory.getCurrentSession().load(
				Skill.class, name);
		if (skill!=null)
			sessionFactory.getCurrentSession().delete(skill);
	}
	
}
