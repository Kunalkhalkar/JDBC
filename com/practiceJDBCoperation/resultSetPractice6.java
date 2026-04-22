package com.practiceJDBCoperation;
import java.sql.*;
public class resultSetPractice6 {
	public static void main(String...x)throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con!= null) {
			System.out.println("connected to database");
			
			Statement stmt = con.createStatement();
			int value = stmt.executeUpdate("delete from students where student_id = 20");
			
			if(value!= 0) {
				System.out.println("value added success fully");
			}
		}
		
	} 
}
