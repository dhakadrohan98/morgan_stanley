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
			
			//createStatememt method()
//			String query = "select * from Students";
//			Statement stmt = con.createStatement();
//			ResultSet set = stmt.executeQuery(query);
			
//			while(set.next()) {
//			int id = set.getInt("id");
//			String name = set.getString(2);
//			String subjects = set.getString(3);
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(subjects);
//		}
			
			//use prepared statement
			String query = "select * from students where firstName = ? AND subjects = ?";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, "Pranav");
			preparedStatement.setString(2, "AstroMaths");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String subject = resultSet.getString(3);
				System.out.println("id - " + id + " | name - " + name + " | subject - " + subject);
			}
			//close the result set and prepared_statement.
			resultSet.close();
			preparedStatement.close();
			con.close();
			System.out.println("All Connections are closed successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
