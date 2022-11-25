package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.HandleBar;
import Classes.HandleBar.Style;
import Classes.Wheel.BrakeStyle;
import Classes.Wheel.StyleWheel;
import Classes.Wheel;

public class DBWheel {
private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	

	public void save(Wheel wheel) {
		String serialNumber = wheel.getSerialNumber();
		String brandName = wheel.getBrandName();
		String  productName = wheel.getProductName();
		int unitCost = wheel.getUnitCost();
		int quantity = wheel.getQuantity();
		String diameter = wheel.getDiameter();
		StyleWheel style = wheel.getStyle();
		BrakeStyle brakeStyle = wheel.getBreakStyle();
		
		 

		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "INSERT INTO team045.Wheel (serialNo,productName,brandName,unitCost,quantity,style,typeOfBrakes,size) VALUES "
						+ "('"+serialNumber+"','"+productName+"','"+brandName+"','"+unitCost+"','"+quantity+"','"+style+"','"+brakeStyle+"','"+diameter+"');";
				
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					wheel.setId(id);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Wheel wheel = new Wheel("abc","abc","abc",1,20,StyleWheel.MOUNTAIN,BrakeStyle.DISK,"26");
		DBWheel dbWheel = new DBWheel();
		dbWheel.save(wheel);	
	}	
}
