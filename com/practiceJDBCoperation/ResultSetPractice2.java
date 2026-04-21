package com.practiceJDBCoperation;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetPractice2 {

	public static void main(String[] args) throws Exception{
		Connection con = connectDB();
		if(con != null) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Students s right join results r on s.student_id = r.student_id where marks_obtained > (select avg(marks_obtained) from results)");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Student_id")+"\t"+ rs.getString("name") + "\t" + rs.getString("email") +"  \t"+ rs.getInt("marks_obtained"));
			}
		}
	}
	
	public static Connection connectDB() {
	
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
			if(con != null) {
				return con;
			}
		
		}
		catch(Exception ex) {
			System.out.println("Exception is : "+ ex);
		}
		return null;
	}

}
