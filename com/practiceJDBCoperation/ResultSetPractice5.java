package com.practiceJDBCoperation;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSetPractice5 {
	public static void main(String ...x) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Students s right join results r on s.student_id = r.student_id where marks_obtained > (select avg(marks_obtained) from results)");
		
		while(rs.next()) {
			System.out.println(rs.getInt("student_id") + "\t"
					+ rs.getString("name")+"  \t"
					+ rs.getString("email") +"  \t"
					+ rs.getString("course")+"  \t"
					+ rs.getInt("marks_obtained"));
		}
	}
}
