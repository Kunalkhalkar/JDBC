package com.practiceJDBCProcedure;
import java.sql.*;
import java.util.*;
public class Procedure1 {
	public static void main(String...x) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam");
		
		if(con != null) {
			
			String query = "";
			PreparedStatement ps = con.prepareStatement(query);
		}
	}
}
