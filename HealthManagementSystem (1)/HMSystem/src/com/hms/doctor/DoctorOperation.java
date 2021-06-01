package com.hms.doctor;

//import java.io.InputStream;
//import java.io.Reader;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.sql.Array;
//import java.sql.Blob;
//import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
//import java.sql.NClob;
//import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
//import java.sql.Ref;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.RowId;
//import java.sql.SQLException;
//import java.sql.SQLWarning;
//import java.sql.SQLXML;
import java.sql.Statement;
//import java.sql.Time;
//import java.sql.Timestamp;
//import java.util.Calendar;

import com.hms.dbconnection.DBConnection;
import com.hms.patient.Patient;

public class DoctorOperation {
	Connection con=DBConnection.getConnection();

	public void addDoctor(Doctor doctor)
	{
		try {
			String q="insert into doctor(id,Name,Specialist,Timing,Qualification,RoomNo) values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,doctor.getDid());
			pst.setString(2,doctor.getDname());
			pst.setString(3,doctor.getSpecialist());
			pst.setString(4,doctor.getAppoint());
			pst.setString(5,doctor.getDoc_qual());
			pst.setInt(6,doctor.getDroom());
			pst.executeUpdate();
			System.out.println("Doctor Details added successfully");
		}catch(Exception e) {
			System.out.println("Exception in Adding Doctor: "+e.getMessage());
		}
     }
	public void getDoctor(String id) {
		try {
			String q="select * from doctor where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,id);
	 		ResultSet rs=pst.executeQuery();
	 		rs.next();
	 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n","id","Name","Specilist","Timing","Qualification","Room No.");
	 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
	 		}catch(Exception e) {
	 			System.out.println(e.getStackTrace());
		    }
	}
	public void getAllDoctor() throws Exception
	{
		String q="select * from doctor";
		Statement st=con.createStatement();
 		ResultSet rs=st.executeQuery(q);
 		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n","id","Name","Specilist","Timing","Qualification","Room No.");
 		while(rs.next())
 		{
 			System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s %-10.10s %-10.10s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
 		}
 	
	}
	public void removeDoctor(String id)
	{
		try {
			String q="delete from doctor where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,id);
			pst.executeUpdate();
			System.out.println("Removed successfully");
			getAllDoctor();
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	public void updateDoctor(String id,Doctor d) throws Exception
	{
		String q="update doctor set Name=?,Specialist=?,Timing=?,Qualification=?,RoomNo=? where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,d.getDname());
		pst.setString(2,d.getSpecialist());
		pst.setString(3,d.getAppoint());
		pst.setString(4,d.getDoc_qual());
		pst.setInt(5,d.getDroom());
		pst.setString(6,id);
		pst.executeUpdate();
		System.out.println("Doctor Id "+id+" Updated successfully");
		getDoctor(id);
	
	}

}
