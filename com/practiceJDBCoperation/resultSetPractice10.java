package com.practiceJDBCoperation;
import java.sql.*;

public class resultSetPractice10 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con!= null) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT c.course_id, c.course_name, COUNT(e.student_id) AS total_students\n"
					+ "FROM Courses c\n"
					+ "JOIN Enrollments e ON c.course_id = e.course_id\n"
					+ "GROUP BY c.course_id, c.course_name\n"
					+ "HAVING COUNT(e.student_id) > 5");
			while(rs.next()) {
				System.out.printf("%d\t %s \t %d\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		}
	}
}
