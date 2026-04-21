package com.practiceJDBCoperation;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.util.*;
 
public class JDBC {
	public static void main(String ...x) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data in employee table name, salary and location");
		
		String name = sc.next();
		int salary = sc.nextInt();
		String location = sc.next();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice", "root", "root");
		//System.out.println(con!=null ? "connnected to database" : "Not connected");
		if(con != null) {
			System.out.println("Database connected");
			Statement stmt = con.createStatement();
			int value = stmt.executeUpdate("Insert into employee values('0',' "+ name +" ' ,' "+ salary+" ',' " + location+ "')");
			System.out.println(value > 0 ? "data inserted" : "Data not Inserted");
			
		}
	}
}
