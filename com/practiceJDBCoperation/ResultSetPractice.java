package com.practiceJDBCoperation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSetPractice {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam","root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from students where course like 'bc%' "); // result set is a class which holds the data of sql table
		
		while(rs.next()) {
			
			int id = rs.getInt("Student_id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String course = rs.getString("course");
			System.out.println(id +"\t" + name + "\t" + email + "\t" + course);
			if(!rs.next()) {
				System.out.println("Out of Data !!");
			}
		}
		
	}

}
