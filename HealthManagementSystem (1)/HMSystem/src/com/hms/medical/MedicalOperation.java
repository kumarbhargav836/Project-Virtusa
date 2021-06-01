package com.hms.medical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hms.dbconnection.DBConnection;
import com.hms.patient.Patient;

public class MedicalOperation {
	Connection con=DBConnection.getConnection();

	public void addMedicine(Medical medical)
	{
		try {
			String q="insert into medical(Name,Company,ExpiryDate,Cost) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,medical.getMed_name());
			pst.setString(2,medical.getMed_comp());
			pst.setString(3,medical.getExp_date());
			pst.setInt(4,medical.getMed_cost());
			pst.executeUpdate();
			System.out.println("Medicine Details added successfully");
		}catch(Exception e) {
			System.out.println("Exception in Adding Medicine: "+e.getMessage());
		}
     }
	public void getMedicine(String name) {
		try {
			String q="select * from medical where Name=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,name);
	 		ResultSet rs=pst.executeQuery();
	 		rs.next();
	 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s\n","med_name","med_comp","exp_date"," med_cost");
	 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
	 		}catch(Exception e) {
	 			System.out.println(e.getStackTrace());
		    }
	}
	public void getAllMedicine() throws Exception
	{
		 System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s\n","med_name","med_comp","exp_date"," med_cost");
	        String q="select * from medical";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			while(rs.next())
			{
				System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
		
	}
	public void removeMedicine(String name)
	{
		try {
			String q="delete from medical where Name=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,name);
			pst.executeUpdate();
			System.out.println("Removed successfully");
			getAllMedicine();
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	public void updateMedicine(String name,Medical m) throws Exception
	{
		String q="update medical set Company=?,ExpiryDate=?,Cost=? where Name=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,m.getMed_comp());
		pst.setString(2,m.getExp_date());
		pst.setInt(3,m.getMed_cost());
		pst.setString(4,name);
		pst.executeUpdate();
		System.out.println("Medicine name "+name+" Updated successfully");
		getMedicine(name);
	
	}



}
