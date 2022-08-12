package com.server.retreiving.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RetreivingData")
public class RetreivingData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {

		try {
			System.out.println("AddUserSevlet.init() method. DB connection created");
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "mysqljavafsd2528967");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//private static void insertIntoDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root",
				"mysqljavafsd2528967"); Statement statement = connection.createStatement();) {

			int rowsInserted = statement.executeUpdate("insert into product values(1, 'laptop', 15)");
			System.out.println("Number of rows inserted: " + rowsInserted);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//private static void readFromDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root",
				"mysqljavafsd2528967"); Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("select * from product");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	

		doGet(request, response);
	}
	

	@Override
	public void destroy() {
		try {
			System.out.println("AddUserSevlet.destroy() method. DB connection closed");
			Connection connection=null;
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
	
