package com.wiley.jdbcapp;

import java.sql.*;

/**
 * App.java
 *
 */
public class App
{
    public static void addCandidate(String firstName, String lastName, Date dob, String email, String phone, int skills[]){
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement psSkills = null;
        ResultSet rs  = null;
        try {
           DBConnection dbcon  = new DBConnection();
           con = dbcon.createDBConnection("wileyclassic");

           String sqlInsert = "Insert into candidates values(first_name,last_name,dob,phone,email)values(?,?,?,?,?)";
con.setAutoCommit(false);
           ps = con.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,firstName);
           ps.setString(2,lastName);
           ps.setDate(3,dob);
           ps.setString(4,phone);
           ps.setString(5,email);
           int rowsAffected  = ps.executeUpdate();
           rs = ps.getGeneratedKeys();

            System.out.println("generated keys" + rs);
            int candidateId = 0;
            if(rs.next()){
                candidateId = rs.getInt(1);
                System.out.println("Candidate Id: "+candidateId);

            }
            if(rowsAffected==1){
                String sqlSkillInsert =  "Insert into candidate_skills(candidate_id,skill_id)values(?,?)";
                psSkills = con.prepareStatement(sqlSkillInsert);


                for(int skillId:skills){
                    psSkills.setInt(1,candidateId);
                    psSkills.setInt(2,skillId);
                    psSkills.executeUpdate();
                }
                con.commit();
            }else {
                System.out.println("Roll back done");
                con.rollback();
            }
        }catch (Exception e){
try{
    if(con!=null)con.rollback();
}catch (SQLException e2){
    System.out.println(e2.getMessage());
}
        }
        finally{
            try{
                if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(psSkills!=null)psSkills.close();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }


    }
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
//        DBConnection dbcon = new DBConnection();
//        Connection conn = DBConnection.createDBConnection();
//        try {
//
//            Statement stmt = conn.createStatement();
//            String sql = "SELECT first_name, last_name, email FROM candidates";
//
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()) {
//                System.out.println("Name: "+rs.getString("first_name")+" "+rs.getString("last_name")
//                        + " - " + rs.getString("email")
//                );
//            }
//
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        int skills[] = {1,2,3};
        addCandidate("Faizan","Shaikh",Date.valueOf("1920-01-20"),"faizanshaikh2100@gmail.com","9518944598",skills);
}
}