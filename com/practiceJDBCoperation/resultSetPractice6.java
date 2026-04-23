package com.practiceJDBCoperation;
import java.sql.*;
public class resultSetPractice6 {
	public static void main(String...x)throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con!= null) {
			System.out.println("connected to database");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(s.student_id), c.course_name from students s join enrollments e on s.student_id = e.student_id join courses c on c.course_id = e.course_id group by e.course_id");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t"+ rs.getString(2));
			}
		}
	} 
}
