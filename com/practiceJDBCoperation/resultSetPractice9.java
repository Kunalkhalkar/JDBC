package com.practiceJDBCoperation;
import java.sql.*;

public class resultSetPractice9 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root","root");
		if(con != null) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select s.name from students s where student_id in(select student_id from results where marks_obtained < 40)");
			while(rs.next()) {
				System.out.printf("%s\n", rs.getString(1));
			}
		}
	}
}
