package com.hms.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hms.dbconnection.DBConnection;

public class Admin {
	Connection con=DBConnection.getConnection();
public void DoctorDetails() throws Exception {
	String q="select * from doctor";
	Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(q);
		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n","id","Name","Specilist","Timing","Qualification","Room No.");
		while(rs.next())
		{
			System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		}
	
}
public void PatientDetails() throws Exception
{
	System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n","pid","pname","disease","sex","admit_status" ,"age");
    String q="select * from patient";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	while(rs.next())
	{
		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
	}

}
}
