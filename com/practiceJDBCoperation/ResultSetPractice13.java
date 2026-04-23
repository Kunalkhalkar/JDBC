package com.practiceJDBCoperation;
import java.sql.*;

public class ResultSetPractice13 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		if(con!= null) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select sum(r.marks_obtained), s.name from results r left join students s  on s.student_id = r.student_id group by r.student_id");
			
			while(rs.next()) {
				System.out.printf("%d \t %s \n", rs.getInt(1), rs.getString(2));
			}
		}
	}
}
