package com.hms.patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hms.dbconnection.DBConnection;
import com.hms.doctor.Doctor;

public class PatientOperation {
	Connection con=DBConnection.getConnection();

	public void addPatient(Patient patient)
	{
		try {
			String q="insert into patient(id,Name,Disease,Gender,AdmitStatus,Age) values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,patient.getPid());
			pst.setString(2,patient.getPname());
			pst.setString(3,patient.getDisease());
			pst.setString(4,patient.getSex());
			pst.setString(5,patient.getAdmit_status());
			pst.setInt(6,patient.getAge());
			pst.executeUpdate();
			System.out.println("Patient Details added successfully");
		}catch(Exception e) {
			System.out.println("Exception in Adding Doctor: "+e.getMessage());
		}
     }
	public void getPatient(String id) {
		try {
			String q="select * from patient where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,id);
	 		ResultSet rs=pst.executeQuery();
	 		rs.next();
	 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n","pid","pname","disease","sex","admit_status" ,"age");
	 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
	 		}catch(Exception e) {
	 			System.out.println(e.getStackTrace());
		    }
	}
	public void getAllPatient() throws Exception
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
	public void removePatient(String id)
	{
		try {
			String q="delete from patient where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,id);
			pst.executeUpdate();
			System.out.println("Removed successfully");
			getAllPatient();
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	public void updatePatient(String id,Patient c) throws Exception
	{
		String q="update patient set Name=?,Disease=?,Gender=?,AdmitStatus=?,Age=? where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,c.getPname());
		pst.setString(2,c.getDisease());
		pst.setString(3,c.getSex());
		pst.setString(4,c.getAdmit_status());
		pst.setInt(5,c.getAge());
		pst.setString(6,id);
		pst.executeUpdate();
		System.out.println("Patient Id "+id+" Updated successfully");
		getPatient(id);
	
	}

}
