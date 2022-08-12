package com.sample.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sample.datalayer.studentDBUtil;
import com.sample.model.student;

@WebServlet("/studentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private studentDBUtil studentDBUtil=null;

	@Resource(name="jdbc/studentwebapp")
	private DataSource datasource;
	
	public void init() throws ServletException {
		super.init();
		this.studentDBUtil = new studentDBUtil(datasource);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<student> students = studentDBUtil.getStudents();
		
		request.setAttribute("STUDENT_LIST", students);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list-students.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		student student = new student(0, firstname, lastname, email);
		
		studentDBUtil.addStudent(student);
		
		doGet(request, response);
		
	}

}