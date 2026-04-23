package com.practiceJDBCoperation;
import java.sql.*;

public class ResultSetPractice15 {
	public static void main(String...x)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		if(con != null) {
			String query = "";
			PreparedStatement psmt = con.prepareStatement(query);
		}
	}
}
