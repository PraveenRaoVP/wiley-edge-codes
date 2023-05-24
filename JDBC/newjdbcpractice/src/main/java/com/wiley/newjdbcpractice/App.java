package com.wiley.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class App {
	public static void addCandidate(String firstName, String lastName, Date dob, String email, String phone,
			int[] skills) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement psSkills = null;
		ResultSet rs = null;

		try {
			DBConnection dbcon = new DBConnection();
			conn = dbcon.createDBConnection();

			/* JDBC Transactions */

			// Disable the autocommit
			conn.setAutoCommit(false);

			// Here is your transaction
			// insert the candidate
			String sqlInsert = "INSERT INTO candidates(first_name, last_name, dob, phone, email) VALUES(?,?,?,?,?)";

			ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setDate(3, dob);
			ps.setString(4, phone);
			ps.setString(5, email);
			
			int rowAffected = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			System.out.println("Generated keys" + rs);
			
			int candidateId = 0;
			if(rs.next())
				candidateId = rs.getInt(1);
			System.out.println("Candidate id: " + candidateId);
			
			if(rowAffected == 1) {
				String sqlSkillInsert = "INSERT INTO candidate_skills(candidate_id, skill_id) VALUES(?,?)";
				
				psSkills = conn.prepareStatement(sqlSkillInsert);
				
				for(int skillId: skills) {
					psSkills.setInt(1, candidateId);
					psSkills.setInt(2, skillId);
					
					psSkills.executeUpdate();
				}
				conn.commit();
			} else {
				System.out.println("roll back done");
				conn.rollback();
			}

			// If everything is ok, commit the transaction
			//conn.commit();

		} catch (SQLException e) {
			try {
				if(conn != null)
					conn.rollback();
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		} finally {
			try {
				if(rs !=null) rs.close();
				if(ps !=null) ps.close();
				if(psSkills !=null) psSkills.close();
				if(conn !=null) conn.close();
				
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		int[] skills = {1,2,3};
		
		addCandidate("Venkat", "B", Date.valueOf("1990-02-04"), "bvsrao91@gmail.com", "9035351966", skills);
	}
}

