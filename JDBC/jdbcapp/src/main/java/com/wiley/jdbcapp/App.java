package com.wiley.jdbcapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	    	System.out.println("6. Search employee record by name");
	    	System.out.println("7. Display sorted employee list by salary");
	    	System.out.println("8. Create new Database");
	    	System.out.println("9. Select database");
	    	System.out.println("10. Drop database");
	    	System.out.println("11. View all databases");
	    	System.out.println("12. Create table in a database");
	    	System.out.println("13. Drop table in a database");
	    	System.out.println("14. Show tables in a database");
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
	    		case 6:
	    			System.out.println("Enter the name of the employee: ");
	    			name = sc.next();
	    			edi.getEmpByName(name);
	    			break;
	    		case 7:
	    			edi.displaySortedEmplist();
	    			break;
	    		case 8:
	    			System.out.println("Enter the name of the new database: ");
	    			String dbName = sc.next();
	    			edi.createNewDatabase(dbName);
	    			break;
	    		case 9:
	    			System.out.println("Enter the name of the database to use: ");
	    			dbName = sc.next();
	    			edi.selectDatabase(dbName);
	    			break;
	    		case 10:
	    			System.out.println("Enter the name of the database to drop: ");
	    			dbName = sc.next();
	    			edi.dropDatabase(dbName);
	    			break;
	    		case 11:
	    			System.out.println("The list of databases");
	    			edi.listDatabases();
	    			break;
	    		case 12:
	    			System.out.println("Enter the database name: ");
	    			dbName = sc.next();
	    			ArrayList<String> fieldNames = new ArrayList<>();
	    			ArrayList<String> fieldTypes = new ArrayList<>();
	    			System.out.println("Enter the name of the table: ");
	    			String tableName = sc.next();
	    			System.out.println("Enter the number of fields: ");
	    			int n = sc.nextInt();
	    			for(int i=0;i<n;i++) {
	    				System.out.println("Enter the name of the field: ");
	    				String fname = sc.next();
	    				System.out.println("Enter the type of the field: ");
	    				String ftype = sc.next();
	    				fieldNames.add(fname);
	    				fieldTypes.add(ftype);
	    			}
	    			Table table = new Table(tableName, fieldNames, fieldTypes);
	    			edi.createTableInDB(dbName, table);
	    			break;
	    		case 13: 
	    			//drop table
	    			System.out.println("Enter the database name: ");
	    			dbName = sc.next();
	    			System.out.println("Enter the table name to be dropped: ");
	    			tableName = sc.next();
	    			edi.dropTableInDB(dbName, tableName);
	    			break;
	    		case 14:
	    			System.out.println("Enter the name of the database: ");
	    			dbName = sc.next();
	    			System.out.println("The tables in the database "+dbName);
	    			edi.getTablesInDB(dbName);
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
