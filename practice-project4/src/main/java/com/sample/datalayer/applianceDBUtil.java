package com.sample.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.model.appliance;

public class applianceDBUtil {
	
	private DataSource dataSource;
	
	public applianceDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<appliance> getAppliance() {
		List<appliance> appliances = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from appliance");
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String appliancename = rs.getString(2);
				String quantity = rs.getString(3);
				appliance appliance = new appliance(id, appliancename, quantity);
				appliances.add(appliance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		
		return appliances;
	}


	public void addAppliance(appliance appliance) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into appliance (appliancename, quantity) values ( ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, appliance.getApplianceName());
			stmt.setString(2, appliance.getquantity());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public List<appliance> getAppliances() {
		// TODO Auto-generated method stub
		return null;
	}



}