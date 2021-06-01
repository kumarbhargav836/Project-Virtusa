package com.hms.main;

import java.util.Calendar;
import java.util.Scanner;

import com.hms.admin.Admin;
import com.hms.doctor.Doctor;
import com.hms.doctor.DoctorOperation;
import com.hms.medical.Medical;
import com.hms.medical.MedicalOperation;
import com.hms.patient.Patient;
import com.hms.patient.PatientOperation;

public class MainClass {
	    public static void main(String args[]) throws Exception
	    {
	    	Scanner sc=new Scanner(System.in);
	        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	        Calendar calendar = Calendar.getInstance();
	        System.out.println("\n--------------------------------------------------------------------------------");
	        System.out.println("            * Welcome to Health Management System Project in Java *");
	        System.out.println("--------------------------------------------------------------------------------");
	        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
	        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
	        Doctor d=new Doctor();
	        DoctorOperation dp=new DoctorOperation();
	        Patient p=new Patient();
	        PatientOperation po=new PatientOperation();
	        Medical m=new Medical();
	        MedicalOperation mo=new MedicalOperation();
	        Admin a=new Admin();
	        Scanner input = new Scanner(System.in);
	        int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1;
	        while (status == 1)
	        {
	            System.out.println("\n                                    MAIN MENU");
	            System.out.println("-----------------------------------------------------------------------------------");
	            System.out.println("1.Doctor  2. Patients  3.Medicines  4.Admin");
	            System.out.println("-----------------------------------------------------------------------------------");
	            choice = input.nextInt();
	            switch (choice)
	            {
	                case 1:
	                    {
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                      *DOCTOR SECTION*");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        s1 = 1;
	                        while (s1 == 1)
	                        {
	                                    System.out.println("1.Add New Entry\n2.Existing Doctors List\n3.Do you want to see details by ID\n4.Do you want to delete a row\n5.Do you want update something");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                    	 System.out.print("id:-");
	                                         d.setDid(sc.next());
	                                         System.out.print("name:-");
	                                         d.setDname(sc.next());
	                                         System.out.print("specilization:-");
	                                         d.setSpecialist(sc.next());
	                                         System.out.print("work time:-");
	                                         d.setAppoint(sc.next());
	                                         System.out.print("qualification:-");
	                                         d.setDoc_qual(sc.next());
	                                         System.out.print("room no.:-");
	                                         d.setDroom(sc.nextInt());
	                                        
	                                    	dp.addDoctor(d);
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                  
	                                    	dp.getAllDoctor();
	                                        
	                                        break;
	                                    }
	                                case 3:
	                                {
	                                	System.out.println("Enter doctor Id");
	                                	String str=sc.next();
	                                	dp.getDoctor(str);
	                                	break;
	                                }
	                                case 4:
	                                {
	                                	System.out.println("Enter doctor ID");
	                                	String str=sc.next();
	                                	dp.removeDoctor(str);
	                                	break;
	                                }
	                               case 5:
	                               {
	                            	    Doctor d1=new Doctor();
	                                	System.out.println("Enter the Doctor ID to update");
	                                	String id=sc.next();
	                                	System.out.println("Enter new Name");
	                                	d1.setDname(sc.next());
	                                	System.out.println("Enter new specialization");
	                                	d1.setSpecialist(sc.next());
	                                	System.out.println("Enter new work time");
	                                	d1.setAppoint(sc.next());
	                                	System.out.println("Enter new qualification");
	                                	d1.setDoc_qual(sc.next());
	                                	System.out.println("Enter new room no.");
	                                	d1.setDroom(sc.nextInt());
	                                	dp.updateDoctor(id,d1);
	                                	break;
	                               }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s1 = input.nextInt();
	                        }
	                        break;
	                    }
	                case 2:
	                    {
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                     *PATIENT SECTION*");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        s2 = 1;
	                        while (s2 == 1)
	                        {
	                            System.out.println("1.Add New Entry\n2.Existing Patients List\n3.Do you want to see patient details by ID\n4.Do you want to remove a patient details\n5.Update patient detail by ID");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                    	 System.out.print("id:-");
	                                         p.setPid(sc.next());
	                                         System.out.print("name:-");
	                                         p.setPname(sc.next());
	                                         System.out.print("disease:-");
	                                         p.setDisease(sc.next());
	                                         System.out.print("sex:-");
	                                         p.setSex(sc.next());
	                                         System.out.print("admit_status:-");
	                                         p.setAdmit_status(sc.next());
	                                         System.out.print("age:-");
	                                         p.setAge(sc.nextInt());
	                                        
	                                        po.addPatient(p);
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                    	 po.getAllPatient();
	                                        break;
	                                    }
	                                case 3:
	                                {
	                                	System.out.println("Enter patient Id");
	                                	String str=sc.next();
	                                	po.getPatient(str);
	                                	break;
	                                }
	                                case 4:
	                                {
	                                	System.out.println("Enter patient ID");
	                                	String str=sc.next();
	                                	po.removePatient(str);
	                                	break;
	                                }
	                                case 5:
	                                {
	                                	Patient p1=new Patient();
	                                	System.out.println("Enter the patient ID to update");
	                                	String id=sc.next();
	                                	System.out.println("Enter new Name");
	                                	p1.setPname(sc.next());
	                                	System.out.println("Enter new disease");
	                                	p1.setDisease(sc.next());
	                                	System.out.println("Enter new gender");
	                                	p1.setSex(sc.next());
	                                	System.out.println("Enter new admit status");
	                                	p1.setAdmit_status(sc.next());
	                                	System.out.println("Enter new age");
	                                	p1.setAge(sc.nextInt());
	                                	po.updatePatient(id, p1);
	                                	break;
	                                }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s2 = input.nextInt();
	                        }
	                        break;
	                    }
	                case 3:
	                    {
	                        s3 = 1;
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                     *MEDICINE SECTION*");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        while (s3 == 1)
	                        {
	                            System.out.println("1.Add New Entry\n2.Existing Medicines List\n3.Do you want to see medicine details by Name\n4.Do you want to remove a medicine detail\n5.Update medicine details by Name");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                	{
	                                		System.out.print("name:-");
	                                        m.setMed_name(sc.next());
	                                        System.out.print("comp:-");
	                                        m.setMed_comp(sc.next());
	                                        System.out.print("exp_date:-");
	                                        m.setExp_date(sc.next());
	                                        System.out.print("cost:-");
	                                        m.setMed_cost(sc.nextInt());
	                                        
	                                        mo.addMedicine(m);
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        mo.getAllMedicine();
	                                        break;
	                                    }
	                                case 3:
	                                {
	                                	System.out.println("Enter medicine name");
	                                	String str=sc.next();
	                                	mo.getMedicine(str);
	                                	break;
	                                }
	                                case 4:
	                                {
	                                	System.out.println("Enter medicine name");
	                                	String str=sc.next();
	                                	mo.removeMedicine(str);
	                                	break;
	                                }
	                                case 5:
	                                {
	                                	Medical m1=new Medical();
	                                	System.out.println("Enter the medicine name to update");
	                                	String name=sc.next();
	                                	System.out.println("Enter new company name");
	                                	m1.setMed_comp(sc.next());
	                                	System.out.println("Enter new expiry date");
	                                	m1.setExp_date(sc.next());
	                                	System.out.println("Enter new cost");
	                                	m1.setMed_cost(sc.nextInt());
	                                	mo.updateMedicine(name,m1);
	                                	break;
	                                }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s3 = input.nextInt();
	                        }
	                        break;
	                    }
	                case 4:
	                    {
	                    	 s4 = 1;
	                    	 System.out.println("--------------------------------------------------------------------------------");
	                         System.out.println("                     *ADMIN SECTION*");
	                         System.out.println("--------------------------------------------------------------------------------");
	                         while(s4==1)
	                         {
	                        	 System.out.println("1.Doctor Information\n2.Patient Information");
	                             c1 = input.nextInt();
	                             switch (c1)
	                             {
	                                 case 1:
	                                     {
	                                    	 a.DoctorDetails();
	                                    	 break;
	                                     }
	                                 case 2:
	                                     {
	                                    	 a.PatientDetails();
	                                         break;
	                                     }
	                             }
	                             System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                             s4 = input.nextInt();

	                         }
	                    }
	                    break;
	                default:
	                {
	                    System.out.println(" You Have Enter Wrong Choice!!!");
	                }
	        }
	        System.out.println("\nReturn to MAIN MENU Press 1");
	        status = input.nextInt();
	        }
	    }
	}
	    


