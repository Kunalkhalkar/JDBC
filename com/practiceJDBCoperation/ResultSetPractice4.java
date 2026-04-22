package com.practiceJDBCoperation;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class ResultSetPractice4 {
	public static void main(String...x) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		if(con!= null) {
			System.out.println("Connection successfull");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select name, email from students where email like '%gmail%'");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+ " \t " + rs.getString(2));
			}
			
		}
	}
	
}
	