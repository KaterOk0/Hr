package com.mycom.service;

import java.util.List;

import com.mycom.entity.Skill;

public interface SkillService {
	public List<Skill> findAll();
	public void insert(Skill skill);
	public void delete(String name);
}
