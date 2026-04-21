package practice_JDBC;
import java.util.*;
import java.sql.*;
//import java.sql.Connection;
//import mysql.cj.jdbc.*;

public class main {
	public static void main(String...x) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/july2025", "root", "root");
		if(conn != null) {
			System.out.println("database connected successfully..");
			Statement stmt = conn.createStatement();
			int value=0;
			try {
			value = stmt.executeUpdate("insert into employee values(8, 'ram','IT', 500000, 8, 'mumbai','2025-02-05')");
			}catch (Exception ex) {
				System.out.println("Exception is : " +ex);
			}
			
				System.out.println(value > 0 ? "inserted": "not Inserted");
		
		}else {
			System.out.println("Database not connected");
		}
	}
}
