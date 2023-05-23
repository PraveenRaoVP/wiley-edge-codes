package com.wiley.jdbcapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App2 {
	
	public void addCandidate(String orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, int customerNumber ) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement psSkills = null;
		ResultSet rs = null;
		try {
			DBConnection dbcon = new DBConnection();
			conn = dbcon.createDBConnection("wileyclassic");
			conn.setAutoCommit(false);
			String sqlInsert = "INSERT INTO orders(orderNumber, orderDate, requiredDate,shippedDate, status,comments,customerNumber) VALUES (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, orderNumber);
			ps.setDate(2, orderDate);
			ps.setDate(3, requiredDate);
			ps.setDate(3, shippedDate);
			ps.setString(4, status);
			ps.setString(5, comments);
			ps.setInt(6, customerNumber);I
			rs = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
