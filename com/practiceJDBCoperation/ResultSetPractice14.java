package com.practiceJDBCoperation;
import java.sql.*;

public class ResultSetPractice14 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root","root");
		if(con != null) {
			String query = " select * from exams e right join results r on e.exam_id = r.exam_id where r.exam_date >= '2025-01-1' and r.exam_date <= '2025-01-31'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%d \t %s \t %s  \t  %s \n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(9));
			}
		}
	}
}
