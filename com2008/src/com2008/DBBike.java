package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Bike;




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
				Statement statement = conn.createStatement();
				String query = "INSERT INTO team045.Customer (forename, surname, address) VALUES ('cemal', 'akdeniz', 1);";
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					System.out.print(resultSet.getInt(1));
				}
				
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("burak");
		}
	}
	
	
	
	

//	public int getId(Bike bike) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	public static void main(String[] args) {
		
		DBBike dbBike = new DBBike();
		dbBike.save();
		
		
		
		
	}





	public int getId(Bike bike) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
