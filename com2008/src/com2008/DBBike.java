package com2008;

import java.awt.datatransfer.FlavorEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Classes.Bike;
import Classes.Frameset;
import Classes.HandleBar;
import Classes.Wheel;
import Classes.Wheel.BrakeStyle;
import Classes.Wheel.StyleWheel;
import Classes.HandleBar.Style;




public class DBBike {
	
	private DBConnection dbConnection;
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	
	public void save(Bike bike) {
		
		
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				
				String query = "INSERT INTO team045.Bike (brandName,unitCost,HandleBarNo,WheelNo,FrameNo) VALUES "
						+ "('"+bike.getBrandName()+"','"+bike.getUnitCost()+"','"+bike.getHandleBar().getId()+"','"+bike.getWheel().getId()+"','"+bike.getFrameset().getId()+"');";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				
				if(resultSet.next()) {
					bike.setSerialNumber(Integer.valueOf(resultSet.getString(1)));
				}
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
		
		}
		
	}
	
	
	
	

//	public int getId(Bike bike) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
//	public static void main(String[] args) {
//		
//		DBBike dbBike = new DBBike();
//		dbBike.save();
//		
//		
//		
//		
//	}

	public int getId(Bike bike) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		Wheel wheel = new Wheel(3,"abc","abc","abc",1,20,StyleWheel.MOUNTAIN,BrakeStyle.DISK,"26");
		Frameset frameset = new Frameset(1,"abc","abc","abc",1,20,"20",true,"26");
		HandleBar handleBar = new HandleBar(1,"abc","abc","abc",1,1,Style.STRAIGHT);
		
		Bike bike = new Bike("abc",handleBar,wheel,frameset);
		DBBike dbBike = new DBBike();
		dbBike.save(bike);
		
		
	}
		
	
	

}
