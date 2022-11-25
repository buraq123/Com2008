package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.result.StringValueFactory;

import Classes.Frameset;



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
	
	
	
	public static void main(String[] args) {
	
	Frameset wheel = new Frameset("abc","abc","abc",1,20,"20",true,"26");
	DBFrameset dbwheel  = new DBFrameset();
	dbwheel.save(wheel);
	
	
	
	
}	
	
	
}
