package com.wiley.newjdbcpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {
	
	public static void executeBatchStatements() throws SQLException {
		Connection conn = null;
		ResultSet rs= null;
		try {
			conn = DBConnection.createDBConnection();
			conn.setAutoCommit(false);
			String insertSQL1 = "INSERT INTO candidates VALUES(140,'Praveen','Rao','2001-10-22','(91)819 7397',vppr@gmail.com)";
			Statement st = conn.createStatement();
			st.addBatch(insertSQL1);
			String insertSQL2 = "INSERT INTO candidate_skills VALUES(140,1)";
			st.addBatch(insertSQL2);
			
			st.executeBatch();
			conn.commit();

		} catch(Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}
	
	    public static void writeBlob(int candidateId, String filename) throws FileNotFoundException, ClassNotFoundException {
	        String query = "UPDATE candidates SET resume = ? WHERE id=?";
	        Connection conn = null;
	        PreparedStatement ps = null;
	        try  {
	        	conn = DBConnection.createDBConnection();
	        	ps = conn.prepareStatement(query);
	            File file = new File(filename);
	            FileInputStream fname = new FileInputStream(file);


	            ps.setBinaryStream(1, fname);
	            ps.setInt(2, candidateId);

	            System.out.println("Added file in the database");
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void getBlobData(int candidateID, String filename) {
	    	Connection conn = null;
	    	ResultSet rs = null;
	    	try {
	    		String sql = "SELECT resume FROM candidates WHERE id = ?";
	    		conn = DBConnection.createDBConnection();
	    		PreparedStatement ps = conn.prepareStatement(sql);
	    		ps.setInt(1, candidateID);
	    		rs= ps.executeQuery();
	    		File file = new File(filename);
	    		FileOutputStream fout = new FileOutputStream(file);
	    		
	    		while(rs.next()) {
	    			InputStream fin = rs.getBinaryStream("resume");
	    			byte[] buffer = new byte[1024];
	    			while(fin.read(buffer) > 0) {
	    				fout.write(buffer);
	    			}
	    		}
	    		System.out.println("File read");
	    		
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}

	    }
	    
	
	public static void main(String[] args) throws SQLException, FileNotFoundException, ClassNotFoundException {
		//executeBatchStatements();
		//writeBlob(133, "D:\\Games\\Work\\WileyEdge\\Codes\\JDBC\\newjdbcpractice\\src\\main\\java\\com\\wiley\\newjdbcpractice\\1.pdf");
		getBlobData(133, "2.pdf");
	}
}
