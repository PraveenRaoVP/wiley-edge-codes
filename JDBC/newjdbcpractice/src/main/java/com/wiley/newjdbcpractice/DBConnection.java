package com.wiley.newjdbcpractice;
// DBConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static String returnDatabaseName() {
		return "jdbc:mysql://localhost:3306/wileyjdbc";
	}
	
	public static Connection createDBConnection() throws SQLException, ClassNotFoundException {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		//String databaseName;
		String url = "jdbc:mysql://localhost:3306/wileyjdbc";
		String name = "root";
		String password = "mysql@123";
		
		Connection conn = DriverManager.getConnection(url,name,password);
		System.out.println("Connection success");
		return conn;
	}
}

