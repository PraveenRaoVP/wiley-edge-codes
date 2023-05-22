package com.wiley.jdbcapp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		String url = "jdbc:mysql://localhost:3306/empdb";
    		String name = "root";
    		String password = "mysql@123";
    	try (Connection conn = DriverManager.getConnection(url, name, password)){
    		//String driver = "com.mysql.cj.jdbc.Driver";
//    		
//    		//Class.forName(driver);
//    		Connection conn = DriverManager.getConnection(url,name,password);
    		//System.out.println("Connection success");
    		
    		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cars");
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			System.out.println(rs.getString("make"));
    		}
    		
    		String statements = "INSERT INTO cars VALUES (?,?,?,?)";
    		
    		try {
    			stmt = conn.prepareStatement(statements);
    			rs = stmt.executeQuery();
    			while(rs.next()) {
    				
    			}
    		} catch(Exception e1) {
    			e1.printStackTrace();
    		}
    		conn.close();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
