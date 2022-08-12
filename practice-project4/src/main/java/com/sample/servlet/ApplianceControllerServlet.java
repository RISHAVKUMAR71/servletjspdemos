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

import com.sample.datalayer.applianceDBUtil;
//import com.sample.datalayer.studentDBUtil;
import com.sample.model.appliance;


@WebServlet("/applianceControllerServlet")
public class ApplianceControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private applianceDBUtil applianceDBUtil;

	@Resource(name="jdbc/appliancewebapp")
	private DataSource datasource=null;
	
	public void init() throws ServletException {
		super.init();
		this.applianceDBUtil = new applianceDBUtil(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<appliance> appliances = applianceDBUtil.getAppliances();
		
		request.setAttribute("APPLIANCE_LIST", appliances);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list-appliances.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appliancename = request.getParameter("appliancename");
		String quantity = request.getParameter("quantity");
		
		
		appliance appliance = new appliance(0, appliancename, quantity);
		
		applianceDBUtil.addAppliance(appliance);
		
		doGet(request, response);
		
	}

}