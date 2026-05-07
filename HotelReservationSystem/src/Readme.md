# 🏨 Hotel Reservation System

## 📌 Description
A Java console-based application to manage hotel room bookings using JDBC and MySQL.

## 🚀 Features
- View Available Rooms
- Book Room
- Cancel Booking
- Display Room Details

## 🛠️ Technologies
- Java
- JDBC
- MySQL

## 📂 Files
- MainApp.java
- rooms.txt

## 🗄️ Database
```sql
CREATE DATABASE hotel;

CREATE TABLE rooms (
  roomno INT PRIMARY KEY,
  roomtype VARCHAR(20),
  roomprice DOUBLE,
  isavailability BOOLEAN
);
