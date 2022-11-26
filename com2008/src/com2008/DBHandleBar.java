package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public List<HandleBar> findAll() {
		
		List<HandleBar> handleBars = new ArrayList<>();
				
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Handlebar where quantity > 0;";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					HandleBar handleBar = new HandleBar(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),Integer.valueOf(resultSet.getString(6)),Style.valueOf(resultSet.getString(7)));
					handleBars.add(handleBar);
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		
		return handleBars;
	}
	
	
	
	
	
	public HandleBar findOne(int id) {
		
		HandleBar handleBar =null;
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Handlebar where idHandlebar = '"+id+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				
				if(resultSet.next()) {
					System.out.println(Integer.valueOf(resultSet.getString(1)));
					handleBar = new HandleBar(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),Integer.valueOf(resultSet.getString(6)),Style.valueOf(resultSet.getString(7)));
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return handleBar;
	}

	
	public void update(HandleBar handleBar) {
		// TODO Auto-generated method stub	
	}


	public static void main(String[] args) {
		DBHandleBar dbHandleBar = new DBHandleBar();
		System.out.println(dbHandleBar.findOne(1).getId()+"fdsfs");
	}

	
	
	
	
	
}
