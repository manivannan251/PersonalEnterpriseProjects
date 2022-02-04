package com.example.testcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbc = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			
			Connection con = DriverManager.getConnection(jdbc, user, pass);
			System.out.println("Connection success");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
