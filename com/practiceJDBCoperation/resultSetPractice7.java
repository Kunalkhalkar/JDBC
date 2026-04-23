package com.practiceJDBCoperation;
import java.sql.*;

public class resultSetPractice7 {
	public static void main(String ...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam","root","root");
		if(con!=null) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from exams where total_marks > (select avg(total_marks) from exams having avg(total_marks) >70)");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getString(3)+ "\t" +rs.getInt(4));
			}
		}
	}
}
