package com.practiceJDBCFileOperation;
import java.sql.*;
import java.io.*;

public class UploadCsv {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "root");
		
		if(con != null) {
			FileReader fr = new FileReader("C:\\Users\\kunal khalkar\\eclipse-workspace\\college.csv");
			BufferedReader br = new BufferedReader(fr);// this BuuferedReader reads a line And it is a class.
			String line= null;
			int value = 0;
			
			String query = "insert into college values(?,?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			while((line = br.readLine()) != null) {// readLine() is a method of bufferedReader
				String []data = line.split(",");
			
					psmt.setInt(1, Integer.parseInt(data[0]));
					psmt.setString(2, data[1]);
					psmt.setString(3, data[2]);
					psmt.setString(4, data[3]);
					psmt.setInt(5, Integer.parseInt(data[4]));
					psmt.setString(6, data[5]);
					
					value = psmt.executeUpdate();
			}
			if(value >0) {
				System.out.println("csv uploaded");
			}
			else {
				System.out.println("csv not uploaded");
			}
		}		
	}

}
