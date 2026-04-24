package com.practiceJDBCFileOperation;
import java.sql.*;
import java.io.*;


public class UploadFromFileByBatchUpdate {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con != null) {
			System.out.println("database connected");
			String query = "insert  into college values(?, ?, ?, ?, ?, ?)";
			PreparedStatement psmt  = con.prepareStatement(query);
			try(FileReader fr = new FileReader("C:\\Users\\kunal khalkar\\eclipse-workspace\\college.csv");
				BufferedReader br = new BufferedReader(fr);
				){
				String line = null;
		}
	}

}
