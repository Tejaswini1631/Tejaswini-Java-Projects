package com.app;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection con = null;

     
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel",
                "root",
                "Teju@1631"  
            );
        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            return;
        }

        
        while (true) {

            System.out.println("\n------Menu------");
            System.out.println("1.View Rooms");
            System.out.println("2.Book Room");
            System.out.println("3.Cancel Booking");
            System.out.println("4.Exit");
            System.out.print("Choose option: ");

            int option = sc.nextInt();

            switch (option) {

               
                case 1:
                    System.out.println("View All the Rooms Available in Our Hotel:");

                    try {
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM rooms");

                        while (rs.next()) {
                            int roomNo = rs.getInt("roomno");
                            String type = rs.getString("roomtype");
                            double price = rs.getDouble("roomprice");
                            boolean isAvailable = rs.getBoolean("isavailability");

                            String status = isAvailable ? "Available" : "Booked";

                            System.out.println("Room_No: " + roomNo +
                                    " || Room_Type: " + type +
                                    " || Room_Price: " + price +
                                    " || Available: " + status);
                        }

                    } catch (Exception e) {
                        System.out.println("Error fetching data");
                    }
                    break;

           
                case 2:
                    System.out.println("Book Rooms");
                    System.out.print("Enter the Room_No you want to Book: ");
                    int roomno = sc.nextInt();

                    try {
                        Statement st1 = con.createStatement();

                        ResultSet rs1 = st1.executeQuery(
                                "SELECT * FROM rooms WHERE roomno = " + roomno
                        );

                        if (rs1.next()) {

                            int rno = rs1.getInt("roomno");
                            String type = rs1.getString("roomtype");
                            double price = rs1.getDouble("roomprice");
                            boolean isAvailable = rs1.getBoolean("isavailability");

                            if (isAvailable) {

                                st1.executeUpdate(
                                        "UPDATE rooms SET isavailability = false WHERE roomno = " + rno
                                );

                                System.out.println("Room Booked Successfully!..");

                                System.out.println("Booking Details:");
                                System.out.println("Room No: " + rno);
                                System.out.println("Type: " + type);
                                System.out.println("Price: " + price);

                                System.out.println("Payment of " + price + " successful!");

                            } else {
                                System.out.println("Room Already Booked!...");
                            }

                        } else {
                            System.out.println("Room not Found!");
                        }

                    } catch (Exception e) {
                        System.out.println("Error in booking");
                    }
                    break;

              
                case 3:
                    System.out.println("❌ Cancel Booking ❌");
                    System.out.print("Enter the Room_No you want to Cancel: ");
                    int roomno1 = sc.nextInt();

                    try {
                        Statement st2 = con.createStatement();

                        ResultSet rs2 = st2.executeQuery(
                                "SELECT * FROM rooms WHERE roomno = " + roomno1
                        );

                        if (rs2.next()) {

                            boolean isAvailable = rs2.getBoolean("isavailability");

                            if (!isAvailable) {

                                st2.executeUpdate(
                                        "UPDATE rooms SET isavailability = true WHERE roomno = " + roomno1
                                );

                                System.out.println("Booking Cancelled Successfully!..");

                            } else {
                                System.out.println("Room is Already Available!...");
                            }

                        } else {
                            System.out.println("Room not Found!");
                        }

                    } catch (Exception e) {
                        System.out.println("Error in cancellation");
                    }
                    break;

                
                case 4:
                    System.out.println("Thank You 😊 Visit Again!");
                    return;

                default:
                    System.out.println("Invalid choose correct one!");
            }
        }
    }
}			

	


