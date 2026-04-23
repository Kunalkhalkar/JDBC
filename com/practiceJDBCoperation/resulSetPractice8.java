package com.practiceJDBCoperation;
import java.sql.*;

public class resulSetPractice8 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con!= null) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select s.name, e.exam_name, r.marks_obtained from students s join results r on r.student_id = s.student_id join exams e on e.exam_id = r.exam_id");
			
			while(rs.next()) {
				System.out.printf("%s \t %s \t %d",rs.getString(1), rs.getString(2), rs.getInt(3));
				System.out.println();
			}
		}
	}
}
