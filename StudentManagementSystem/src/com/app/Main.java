package com.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.*;
public class Main {
	
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rs;

	static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db","root","Teju@1631");
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	static void addStudent() {
		
		System.out.println("Enter RollNo: ");
		int Rollno=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Name: ");
		String Name=sc.nextLine();
		
		System.out.println("Enter the Grade: ");
		String Grade=sc.nextLine();
		
		
		String Query="Insert into student values(?,?,?)";
		try {
		con = getConnection();
		pstmt=con.prepareStatement(Query);
		
		pstmt.setInt(1, Rollno);
		pstmt.setString(2, Name);
		pstmt.setString(3,Grade);
		
		int rows=pstmt.executeUpdate();
		if(rows > 0) {
		    System.out.println("Student added Successfully!...");
		} else {
		    System.out.println("Insertion failed");
		}
		
		
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}
		
		
		

	}
	static void viewStudent() {
		try {
			con=getConnection();
			String Query="select * from student";
			stmt=con.createStatement();
			
			
			
			rs=stmt.executeQuery(Query);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" , "+rs.getString(2)+" , "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
			
	}
	static void searchStudent() {
		System.out.println("Enter Roll No to Search:");
		int Roll=sc.nextInt();
		
		try {
			con=getConnection();
			String Query="select * from student where rollno=?";
			pstmt=con.prepareStatement(Query);
			
			pstmt.setInt(1, Roll);
			
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" , "+rs.getString(2)+" , "+rs.getString(3));
			}
			else {
				System.out.println("Student not Found");
			}
			
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
		
	}
	static void updateStudent() {
		System.out.println("Enter Roll No to Search:");
		int Roll=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Name: ");
		String Name=sc.nextLine();
		
		System.out.println("Enter the Grade: ");
		String Grade=sc.nextLine();
		try {
			con=getConnection();
			String Query="update student set name=?,grade=? where Rollno=?";
			pstmt=con.prepareStatement(Query);
			
			pstmt.setInt(3, Roll);
			pstmt.setString(1, Name);
			pstmt.setString(2,Grade);
			
			
			
			int rows=pstmt.executeUpdate();
			if(rows>0) {
				System.out.println("Student Updated Successfully!...");
			}
			else {
				System.out.println("Student not Found");
			}
			con.close();
		
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
		
		
		
		

		
		
	
	static void deleteStudent() {
		System.out.println("Enter Roll No to Search:");
		int Roll=sc.nextInt();
		try {
			con=getConnection();
			String Query="delete from student where rollno=?";
			pstmt=con.prepareStatement(Query);
			
			
			pstmt.setInt(1, Roll);
			int rows=pstmt.executeUpdate();
			if(rows>0) {
				System.out.println("Student was deleted Successfully!...");
			}
			else {
				System.out.println("student not Found");
			}
			
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
			
		
	}


	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		for(;;) {
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
		
			
			System.out.println("Enter your Choice: ");
			int choice=sc.nextInt();
			if(choice==1) {
				addStudent();
				
			}
			else if(choice==2) {
				viewStudent();
			
			}
			else if(choice==3) {
				searchStudent();
				
			}
			else if(choice==4) {
				updateStudent();
				
			}
			else if(choice==5) {
				deleteStudent();
				
			}
			else if(choice==6) {
				System.out.println("Thank You ! visit again...");
				System.exit(0);
				
			}
			else {
				System.out.println("Invalid Choice");
			}
			
				
			}
			
		}
		

		
	}


