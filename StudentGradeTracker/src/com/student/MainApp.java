package com.student;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
	String name;
	int marks;
	Student(String name,int marks){
		this.name=name;
		this.marks=marks;
		}
	
}

public class MainApp {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList <Student> al = new ArrayList();
		for(;;) {
		System.out.println("-----Student Grade Tracker-----");
		System.out.println("1.Add Student");
		System.out.println("2.view Report");
		System.out.println("3.Exit");
		System.out.println("Enter your choice:");
		
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("Enter Your Name:");
			String name=sc.next();
			System.out.println("Enter Your Marks:");
			int marks=sc.nextInt();
			Student s1=new Student(name,marks);
			al.add(s1);
		}
		else if(choice==2) {
			if(al.isEmpty()) {
				System.out.println("No data Available");
			}
			else {
				int total=0;
				int highest=al.get(0).marks;
				int lowest=al.get(0).marks;
				System.out.println("-----Student Report-----");
				
				for(Student s:al) {
					
					System.out.println("Name: "+s.name+" | Marks: "+s.marks);
					total += s.marks;
					if(s.marks>highest) {
						highest=s.marks;
						
					}
					if(s.marks<lowest) {
						lowest=s.marks;
						
					}

				}
				double avg=(double)total/al.size();
				System.out.println("Average: "+avg);
				System.out.println("Highest: "+highest);
				System.out.println("Lowest: "+lowest);
			}
			
				
			}
		else if(choice==3) {
			System.out.println("Thank You!...");
			break;
			
		}
		else {
			System.out.println("Invalid Choice!..");
			
		}
		
	}
		sc.close();
		
		}

}
