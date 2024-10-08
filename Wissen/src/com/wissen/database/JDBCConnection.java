package com.wissen.database;

import java.sql.*;

public class JDBCConnection {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/student"; // table details
			String username = "root"; // MySQL credentials
			String password = "root";

			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// creating a connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully");
			
			//create statememt
			String query = "select * from Students";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString(2);
				String subjects = set.getString(3);
				System.out.println(id);
				System.out.println(name);
				System.out.println(subjects);
			}
			con.close();
			System.out.println("Connection closed successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
