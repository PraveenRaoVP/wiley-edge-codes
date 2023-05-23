package com.wiley.jdbcapp;
// DBConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static String returnDatabaseName(String database) {
		return "jdbc:mysql://localhost:3306/" + database;
	}
	
	public static Connection createDBConnection(String dbName) throws SQLException, ClassNotFoundException {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		//String databaseName;
		String url = returnDatabaseName(dbName);
		String name = "root";
		String password = "mysql@123";
		
		Connection conn = DriverManager.getConnection(url,name,password);
	//	System.out.println("Connection success");
		return conn;
	}
}
