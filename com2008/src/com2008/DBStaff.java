package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.HandleBar;
import Classes.Staff;
import Classes.HandleBar.Style;

public class DBStaff {
	
	
private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";

	public Staff findOne(String username1, String password1) {
		
		Staff staff  =null;
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Staff where username = '"+username1+"' AND password ='"+password1+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				
				if(resultSet.next()) {
					staff = new Staff(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return staff;
	}

}
