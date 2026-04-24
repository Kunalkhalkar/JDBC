package com.practiceJDBCFileOperation;
import java.sql.*;
import java.io.*;

public class InsertDataFromFile {
	public static void main(String...x)throws Exception{
		FileReader fr = new FileReader("C:\\Users\\kunal khalkar\\eclipse-workspace\\students.csv"); 
		BufferedReader br = new BufferedReader(fr);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con != null) {
			
			int value =0;
			
			while(br.readLine() != null) {
				String line[] = null;
				String query ="insert into students values(?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				line = br.readLine().split(",");
				ps.setInt(1, Integer.parseInt(line[0]));
				ps.setString(2, line[1].trim());
				ps.setString(3, line[2].trim());
				ps.setString(4, line[3].trim());
				value = ps.executeUpdate();
			}
			if(value > 0) {
				System.out.println("csv uploaded");
			}
			else {
				System.out.println("csv Not uploaded");
			}
		}
		
		
	}
}
