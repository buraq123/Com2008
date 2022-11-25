package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.HandleBar;
import Classes.HandleBar.Style;

public class DBHandleBar {
	
	private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	

	public void save(HandleBar handleBar) {
		String serialNumber = handleBar.getSerialNumber();
		String brandName = handleBar.getBrandName();
		String  productName = handleBar.getProductName();
		int unitCost = handleBar.getUnitCost();
		int quantity = handleBar.getQuantity();
		 Style style = handleBar.getStyle();
		 

		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "INSERT INTO team045.Handlebar (serialNo,productName,brandName,unitCost,quantity,style) VALUES "
						+ "('"+serialNumber+"','"+productName+"','"+brandName+"','"+unitCost+"','"+quantity+"','"+style+"');";
				
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					handleBar.setId(id);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public HandleBar findOne(String seiralNo, String brandName) {
		return null;
		// TODO Auto-generated method stub	
	}

	
	public void update(HandleBar handleBar) {
		// TODO Auto-generated method stub	
	}
	
	
	
	
	
}
