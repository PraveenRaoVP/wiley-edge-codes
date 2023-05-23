package com.wiley.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection conn;
	
	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.createDBConnection("wileyjdbc");
			String query = "INSERT INTO employee VALUES (?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setDouble(3, emp.getSalary());
			stmt.setInt(4, emp.getAge());
			
			int count = stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Employee inserted successfully");
			} else {
				System.out.println("There was an error inserting Employee record");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void getEmployees() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		conn = DBConnection.createDBConnection("wileyjdbc");
		String query = "SELECT * FROM employee";
		System.out.println("-------------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\t\n", "ID","Name","Salary","Age");
		System.out.println("-------------------------------------------");
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.format("%d\t%s\t%.2f\t%d\t\n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
				System.out.println("-------------------------------------------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getEmpByID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		conn = DBConnection.createDBConnection("wileyjdbc");
		String query = "SELECT * FROM employee WHERE id = "+id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("-------------------------------------------");
			System.out.format("%s\t%s\t%s\t%s\t\n", "ID","Name","Salary","Age");
			System.out.println("-------------------------------------------");
			while(rs.next()) {
				System.out.format("%d\t%s\t%.2f\t%d\t\n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmpByName(int id, String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.createDBConnection("wileyjdbc");
			String query = "UPDATE employee SET Name=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			int count = stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Updated the employee name");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmp(int id) throws ClassNotFoundException, SQLException {
		try {
			conn = DBConnection.createDBConnection("wileyjdbc");
			String query = "DELETE FROM employee WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();
			
			if(count!=0) {
				System.out.println("Employee deleted successfully");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getEmpByName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.createDBConnection("wileyjdbc");
			String query = "SELECT * FROM employee WHERE name like '%"+name+"%'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("-------------------------------------------");
			System.out.format("%s\t%s\t%s\t%s\t\n", "ID","Name","Salary","Age");
			System.out.println("-------------------------------------------");
			while(rs.next()) {
				System.out.format("%d\t%s\t%.2f\t%d\t\n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displaySortedEmplist() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM employee ORDER BY salary desc";
		try {
			conn = DBConnection.createDBConnection("wileyjdbc");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("-------------------------------------------");
			System.out.format("%s\t%s\t%s\t%s\t\n", "ID","Name","Salary","Age");
			System.out.println("-------------------------------------------");
			while(rs.next()) {
				System.out.format("%d\t%s\t%.2f\t%d\t\n", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createNewDatabase(String databaseName) throws ClassNotFoundException, SQLException {
		conn = DBConnection.createDBConnection("");
		Statement stmt = conn.createStatement();
		String query = "CREATE DATABASE "+databaseName;
		stmt.executeUpdate(query);
		System.out.println("Database "+databaseName+" is created");
	}
	
	public Connection selectDatabase(String databaseName) throws ClassNotFoundException, SQLException{
		conn = DBConnection.createDBConnection(databaseName);
		System.out.println("Database "+databaseName+" is being used");
		String query = "SHOW TABLES";
		System.out.println("The tables present:-");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		return conn;
	}
	public void dropDatabase(String databaseName) throws ClassNotFoundException, SQLException {
		conn = DBConnection.createDBConnection("");
		String query = "DROP DATABASE " + databaseName;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		System.out.println("The database "+databaseName+" has been dropped");
	}
	
	public void listDatabases() throws ClassNotFoundException, SQLException{
		conn = DBConnection.createDBConnection("");
		String query = "SHOW DATABASES";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
	
	public void createTableInDB(String dbName, Table table) throws ClassNotFoundException, SQLException{
		conn = DBConnection.createDBConnection(dbName);
		String query = "CREATE TABLE "+table.getTableName()+"(";
		for(int i=0;i<table.getFieldNames().size();i++) {
			query+=table.getFieldNames().get(i)+" "+table.getFieldTypes().get(i);
			if(i!=table.getFieldNames().size()-1) {
				query+=", ";
			}
		}
		query+=")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		System.out.println("Table created successfully");
	}
	
	public void getTablesInDB(String dbName) throws ClassNotFoundException, SQLException{
		conn = DBConnection.createDBConnection(dbName);
		String query = "SHOW TABLES";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
	
	public void dropTableInDB(String dbName, String tableName) throws ClassNotFoundException, SQLException{
		conn = DBConnection.createDBConnection(dbName);
		String query = "DROP TABLE " + tableName;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		System.out.println("Table dropped");
	}
}
