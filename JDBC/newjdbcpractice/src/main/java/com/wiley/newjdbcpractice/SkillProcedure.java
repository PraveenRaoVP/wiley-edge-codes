package com.wiley.newjdbcpractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SkillProcedure {
	
	public static void getCandidateSkills(int candidateId) {
		String storeProcedureSQL = "{call get_candidate_skill(?)}";
		Connection conn = null;
		ResultSet rs = null;
		try {
			DBConnection dbcon = new DBConnection();
			conn = dbcon.createDBConnection();
			CallableStatement cst = conn.prepareCall(storeProcedureSQL);
			cst.setInt(1,candidateId);
			rs = cst.executeQuery();
			while(rs.next()) {
				System.out.println(String.format("%s - %s", rs.getString("first_name"), rs.getString("skill")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getCandidateSkills(133);
	}
}
