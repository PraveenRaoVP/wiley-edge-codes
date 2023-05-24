package com.wiley.bookpub.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.wiley.bookpub.model.Skillstore;
import com.wiley.bookpub.util.DBConnection;
import com.wiley.bookpub.util.SkillQuery;

public class SkillDaoImpl implements ISkillDao {

	PreparedStatement pst;
	int result = 0;
	
	public int addSkill(Skillstore skill) {
		try {
			pst = DBConnection.getDBConnection().prepareStatement(SkillQuery.addSkill);
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}

	public List<Skillstore> skillList(Skillstore skill) {
		// TODO Auto-generated method stub
		return null;
	}

}