package com.server.retreiving.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retreiving {

	public static void main(String[] args) {

		 readFromDB();
	//	insertIntoDB();

	}

	private static void insertIntoDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root",
				"mysqljavafsd2528967"); Statement statement = connection.createStatement();) {

			int rowsInserted = statement.executeUpdate("insert into product values(2, 'phone', 95)");
			System.out.println("Number of rows inserted: " + rowsInserted);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void readFromDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root",
				"mysqljavafsd2528967"); Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("select * from product where pid=1");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

