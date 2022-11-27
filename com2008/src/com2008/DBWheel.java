package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	
	public List<Wheel> getAll() {
		
		List<Wheel>  wheels = new ArrayList<>();
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Wheel where quantity > 0;";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					Wheel wheel = new Wheel(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),
							Integer.valueOf(resultSet.getString(6)),StyleWheel.valueOf(resultSet.getString(7)),BrakeStyle.valueOf(resultSet.getString(8)),resultSet.getString(9));
					wheels.add(wheel);
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return wheels;
	}	
	
	
	

	public Wheel findOne(int wheelId) {
		
		Wheel wheel = null;
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Wheel where idWheel = '"+wheelId+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					wheel = new Wheel(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),
							Integer.valueOf(resultSet.getString(6)),StyleWheel.valueOf(resultSet.getString(7)),BrakeStyle.valueOf(resultSet.getString(8)),resultSet.getString(9));		
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return wheel;
	}


	public void updateStock(Wheel wheel) {
		 

		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "UPDATE team045.Wheel SET quantity = '"+wheel.getQuantity()+"' WHERE idWHeel = '"+wheel.getId()+"' "
						;
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		
	}


	public Wheel findOne(String serialNumber, String brandName) {

		Wheel wheel = null;
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Wheel where serialNo = '"+serialNumber+"'AND brandName = '"+brandName+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					wheel = new Wheel(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),
							Integer.valueOf(resultSet.getString(6)),StyleWheel.valueOf(resultSet.getString(7)),BrakeStyle.valueOf(resultSet.getString(8)),resultSet.getString(9));		
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return wheel;
	}


	public void deleteStock(int id) {
		
		
	}
	
	
	
	
	
	

//	public static void main(String[] args) {
//		
//		Wheel wheel = new Wheel("abc","abc","abc",1,20,StyleWheel.MOUNTAIN,BrakeStyle.DISK,"26");
//		DBWheel dbWheel = new DBWheel();
//		System.out.print(dbWheel.findOne(1));	
//	}


}
