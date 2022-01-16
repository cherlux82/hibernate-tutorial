package com.draggerco.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJbc {

	public static void main(String[] args) {
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
			String usr = "hbstudent";
			String pwd = "hbstudent";

			System.out.println("Conectando a la base de datos: " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, usr, pwd);

			System.out.println("Connected!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
