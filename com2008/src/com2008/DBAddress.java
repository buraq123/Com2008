package com2008;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Address;
import Classes.Customer;

public class DBAddress {
	
	
private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	
	
	
	
	
	public void save(Address address) {
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
	
				String query = "INSERT INTO team045.Address (houseNumber,postcode,city,roadName) VALUES "
						+ "('"+address.getHouseNumber()+"','"+address.getPostcode()+"','"+address.getCityName()+"','"+address.getRoadName()+"');";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				
				
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					address.setId(id);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}





	public Address findOne(String houseNumber,String postcode) {
		
		Address address = null;
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Address  WHERE houseNumber = '"+houseNumber+"' AND postcode= '"+postcode+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					address = new Address(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5));
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return address;
	}
	
	

}
