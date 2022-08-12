package com.sample.model;

import javax.sql.DataSource;

public class appliance {
	
	private int id;
	private String applianceName;
	private String quantity;
	
	public appliance(int id, String applianceName, String quantity) {
		super();
		this.id = id;
		this.applianceName = applianceName;
		this.quantity = quantity;
	}
	
	public appliance(DataSource datasource) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApplianceName() {
		return applianceName;
	}
	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}
	public String getquantity() {
		return quantity;
	}
	public void setquantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Appliance [id=" + id + ", applianceName=" + applianceName + ", quantity=" + quantity + "]";
	}

}