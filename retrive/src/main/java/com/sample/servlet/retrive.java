package com.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class retrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("pid"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root",
					"mysqljavafsd2528967");
			PreparedStatement pstmt = con.prepareStatement("select * from product where id =?");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				System.out.println("pid is " + res.getInt("pid") + " Name is " + res.getString("name") + "price is "
						+ res.getFloat("price"));
//				
			}

			// rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}