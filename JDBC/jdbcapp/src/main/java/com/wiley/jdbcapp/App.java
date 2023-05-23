package com.wiley.jdbcapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

/**
 * App.java
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
//    	DBConnection dbcon = new DBConnection();
//    	try {
//			Connection conn = dbcon.createDBConnection();
//			
//			Statement stmt = conn.createStatement();
//			String sql = "SELECT first_name, last_name, email FROM candidates";
//			
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				System.out.println("Name: "+rs.getString("first_name")+" "+rs.getString("last_name")
//							+ " - " + rs.getString("email")
//						);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	Scanner sc = new Scanner(System.in);
    	EmployeeDaoImpl edi = new EmployeeDaoImpl();
    	int ch=0;
    	do {
	    	System.out.println("1. Create a new employee record");
	    	System.out.println("2. Show all employee records");
	    	System.out.println("3. Show employee record by id");
	    	System.out.println("4. Update employee name by id");
	    	System.out.println("5. Delete employee record by id");
	    	System.out.print("Enter a choice: ");
	    	int choice = sc.nextInt();
	    	switch(choice) {
	    		case 1:
	    			System.out.print("Enter the id of employee: ");
	    			int id = sc.nextInt(); //System.out.println();
	    			System.out.print("Enter the name of the employee: ");
	    			String name = sc.next();// System.out.println();
	    			System.out.print("Enter the salary of the employee: ");
	    			double salary = sc.nextDouble();// System.out.println();
	    			System.out.print("Enter the age of the employee: ");
	    			int age = sc.nextInt(); //System.out.println();
	    			Employee emp = new Employee(id,name,salary,age);
	    			edi.createEmployee(emp);
	    			break;
	    		case 2:
	    			edi.getEmployees();
	    			break;
	    		case 3:
	    			System.out.println("Enter the employee number: ");
	    			int ide = sc.nextInt();
	    			edi.getEmpByID(ide);
	    			break;
	    		case 4:
	    			System.out.println("Enter the employee id number to update: ");
	    			int idNum = sc.nextInt();
	    			System.out.println("Enter the change of name: ");
	    			String names = sc.next();
	    			edi.updateEmpByName(idNum, names);
	    			break;
	    		case 5:
	    			System.out.println("Enter the employee id to delete: ");
	    			int idx = sc.nextInt();
	    			edi.deleteEmp(idx);
	    			break;
	    		default:
	    			System.out.println("Wrong choice");
	    	}
	    	System.out.println("Do you wish to perform further operations? (1 for yes)");
	    	ch = sc.nextInt();
    	} while(ch==1);
    	sc.close();
    }
}
