package com.practiceJDBCoperation;
import java.util.*;
import java.sql.*;
public class ResulteSetPractice12 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con!= null) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students where student_id not in(select student_id from results)");
			while(rs.next()) {
				System.out.printf("%d \t %s \t %s", rs.getInt(1), rs.getString(2), rs.getString(4));
			}
		}
	}
}
