package com.practiceJDBCoperation;
import java.sql.*;

public class ResultSetPractice15 {
	public static void main(String...x)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		if(con != null) {
			String query = "select * from students";
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%d \t %s \t %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		}
	}
}
