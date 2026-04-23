package com.practiceJDBCoperation;
import java.sql.*;

public class resultSetPractice11 {
	public static void main(String ...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con!= null) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT s.student_id, s.name, r.exam_id, r.marks_obtained\r\n"
					+ "FROM Results r\r\n"
					+ "JOIN (\r\n"
					+ "    SELECT exam_id, MAX(marks_obtained) AS max_marks\r\n"
					+ "    FROM Results\r\n"
					+ "    GROUP BY exam_id\r\n"
					+ ") t ON r.exam_id = t.exam_id \r\n"
					+ "    AND r.marks_obtained = t.max_marks\r\n"
					+ "JOIN Students s ON s.student_id = r.student_id");
			while(rs.next()) {
				System.out.printf("%d \t %s \t %d \t %d\n",rs.getInt(1),  rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		}
	}
}
