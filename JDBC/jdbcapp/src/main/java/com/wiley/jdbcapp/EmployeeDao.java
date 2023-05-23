package com.wiley.jdbcapp;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmployeeDao {
	// create employee
	public void createEmployee(Employee emp);
	// show all employees
	public void getEmployees() throws ClassNotFoundException, SQLException;
	// show employee based on id
	public void getEmpByID(int id) throws ClassNotFoundException, SQLException;
	//update employee
	public void updateEmpByName(int id, String name) throws ClassNotFoundException, SQLException;
	//delete employee
	public void deleteEmp(int id) throws ClassNotFoundException, SQLException;
	// search emp by name
	public void getEmpByName(String name) throws ClassNotFoundException, SQLException;
	// display sorted emp by salary
	public void displaySortedEmplist() throws ClassNotFoundException, SQLException;
	//create new database
	public void createNewDatabase(String databaseName) throws ClassNotFoundException, SQLException;
	//select database
	public Connection selectDatabase(String databaseName) throws ClassNotFoundException, SQLException;
	//drop database
	public void dropDatabase(String databaseName) throws ClassNotFoundException, SQLException;
	//list databases
	public void listDatabases() throws ClassNotFoundException, SQLException;
	//create table
	public void createTableInDB(String dbname, Table table) throws ClassNotFoundException, SQLException;
	//drop table
	public void dropTableInDB(String dbname, String tableName) throws ClassNotFoundException, SQLException;
	//display tables
	public void getTablesInDB(String dbname) throws ClassNotFoundException, SQLException;
}
