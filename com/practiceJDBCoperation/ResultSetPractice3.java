package com.practiceJDBCoperation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetPractice3 {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from courses");
		
		while(rs.next()) {
			System.out.println(rs.getInt("course_id") + " \t"+ rs.getString("course_name"));
		}
	}

}
