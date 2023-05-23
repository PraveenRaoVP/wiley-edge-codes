package com.wiley.jdbcapp;

import java.util.ArrayList;

public class Table {
	private String tableName;
	private ArrayList<String> fieldNames;
	private ArrayList<String> fieldTypes;

	public Table(String tableName, ArrayList<String> fieldNames, ArrayList<String> fieldTypes) {
		super();
		this.tableName = tableName;
		this.fieldNames = fieldNames;
		this.fieldTypes = fieldTypes;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public ArrayList<String> getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(ArrayList<String> fieldNames) {
		this.fieldNames = fieldNames;
	}
	public ArrayList<String> getFieldTypes() {
		return fieldTypes;
	}
	public void setFieldTypes(ArrayList<String> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}
}
