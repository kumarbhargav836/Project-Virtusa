package com.hms.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/healthmanagmentsystem";
			con=DriverManager.getConnection(url,"root","Mysql@123");
		}
		catch(Exception e) {
			System.out.println("Exception occured in DB connection : "+e.getMessage());
		}
		return con;
	}
}
