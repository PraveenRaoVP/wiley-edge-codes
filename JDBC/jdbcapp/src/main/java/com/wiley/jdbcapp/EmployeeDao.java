package com.wiley.jdbcapp;

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
}
