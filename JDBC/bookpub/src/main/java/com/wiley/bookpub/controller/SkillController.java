package com.wiley.bookpub.controller;

import com.wiley.bookpub.dao.SkillDaoImpl;
import com.wiley.bookpub.model.Skillstore;

public class SkillController {

	SkillDaoImpl impl = new SkillDaoImpl();
	
	public int addSkill(int id, String bookName, int isbn, String author, int edition) {
	
		Skillstore skill = new Skillstore(id, bookName, isbn, author, edition);
		return impl.addSkill(skill);
	}
}