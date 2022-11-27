package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.result.StringValueFactory;

import Classes.Frameset;
import Classes.HandleBar;
import Classes.HandleBar.Style;



public class DBFrameset {
	
	private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	

	public void save(Frameset frameset) {
		
		String serialNumber = frameset.getSerialNumber();
		String brandName = frameset.getBrandName();
		String  productName = frameset.getProductName();
		int unitCost = frameset.getUnitCost();
		int quantity = frameset.getQuantity();
		String size =frameset.getSize();
		Boolean shocks = frameset.getShocks();
	
		String shocksdb;
		if(shocks==true) {
			shocksdb ="YES";
		}
		else {
			shocksdb="NO";
		}
		String gears = frameset.getGear();
		 

		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "INSERT INTO team045.Frame (serialNo,productName,brandName,unitCost,quantity,size,shocks,gear) VALUES "
						+ "('"+serialNumber+"','"+productName+"','"+brandName+"','"+unitCost+"','"+quantity+"','"+size+"','"+shocksdb+"','"+gears+"');";
				
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					frameset.setId(id);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}
	

	public List<Frameset> getAll() {
		
		List<Frameset> framesets = new ArrayList<>();
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Frame where quantity > 0;";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					Boolean shocks;
					if(resultSet.getString(8).equals("YES")) {
						shocks = true;
					}
					else {
						shocks = false;
					}
							
					Frameset frameset = new Frameset(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),Integer.valueOf(resultSet.getString(6)),resultSet.getString(7),shocks,resultSet.getString(9));
					
				   framesets.add(frameset);
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return framesets;
	}
	
	
//	public static void main(String[] args) {
//		
//	Frameset wheel = new Frameset("abc","abc","abc",1,20,"20",true,"26");
//	DBFrameset dbwheel  = new DBFrameset();
//	System.out.print(dbwheel.getAll());
//	
//	
//	
//}


	public Frameset findOne(int id) {
		
		Frameset frameset = null; 
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Frame where idFrame = '"+id+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					Boolean shocks;
					if(resultSet.getString(8).equals("YES")) {
						shocks = true;
					}
					else {
						shocks = false;
					}
							
					frameset = new Frameset(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),Integer.valueOf(resultSet.getString(6)),resultSet.getString(7),shocks,resultSet.getString(9));
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return frameset;
	}


	public void updateStock(Frameset frameset) {
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "UPDATE team045.Frame SET quantity = '"+frameset.getQuantity()+"' WHERE idFrame = '"+frameset.getId()+"' "
						;
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		
	}


	public Frameset findOne(String serialNumber, String brandName) {
	Frameset frameset = null; 
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Frame where serialNo = '"+serialNumber+"' AND brandName = '"+brandName+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					Boolean shocks;
					if(resultSet.getString(8).equals("YES")) {
						shocks = true;
					}
					else {
						shocks = false;
					}
							
					frameset = new Frameset(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
							Integer.valueOf(resultSet.getString(5)),Integer.valueOf(resultSet.getString(6)),resultSet.getString(7),shocks,resultSet.getString(9));
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return frameset;
	}
	
	
	
	
	
}
