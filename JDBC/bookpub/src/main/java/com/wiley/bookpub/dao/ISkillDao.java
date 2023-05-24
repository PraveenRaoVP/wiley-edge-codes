package com.wiley.bookpub.dao;

import java.util.List;

import com.wiley.bookpub.model.Skillstore;

public interface ISkillDao {
	
	public int addSkill(Skillstore skill);
	
	public List<Skillstore> skillList(Skillstore skill);
	//remove
	//update
	
}