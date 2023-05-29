package com.wiley.bookpub.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnection {
	private DBConnection() {
		
	}
	
	public static Connection getDBConnection() {
		Connection dbcon = null;
		ResourceBundle bundle = ResourceBundle.getBundle("db");

		try {
			dbcon = DriverManager.getConnection(
						bundle.getString("url"),
						bundle.getString("username"),
						bundle.getString("password")
					);
		} catch (Exception e) {
			System.out.println("DB conneciton error occured");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("db connected successfully");
		return dbcon;
	}
}