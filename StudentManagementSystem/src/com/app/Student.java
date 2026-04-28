package com.app;

public class Student {
	
	
	int Rollno;
	String Name;
	String Grade;
	
	public Student(int rollno, String name, String grade) {
		
		Rollno = rollno;
		Name = name;
		Grade = grade;
	}
	
	public void display() {
		System.out.println("RollNo: "+Rollno);
		System.out.println("Name: "+Name);
		System.out.println("Grade: "+Grade);
		}

}
