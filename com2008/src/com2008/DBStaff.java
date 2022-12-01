package com2008;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.DynamicAny._DynValueStub;

import Classes.HandleBar;
import Classes.Staff;
import Classes.HandleBar.Style;

public class DBStaff {
	
	
private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	
	
	
	
	

	public  Staff findOne(String username1, String password1) throws NoSuchAlgorithmException {
		
		Staff staff  =null;
		
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				Statement statement2 = conn.createStatement();
				String query = "SELECT username FROM team045.Staff where username = '"+username1+"' AND password = '"+DBStaff.hashString(password1)+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					staff = new Staff(resultSet.getString(1));

				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return staff;
	}
	
	public  Staff insert(String username1, String password1) throws NoSuchAlgorithmException {
		
		Staff staff  =null;
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				
				String query = "INSERT INTO team045.Staff (username,password) VALUES ('"+username1+"','"+DBStaff.hashString(password1)+"');";
				PreparedStatement statement = conn.prepareStatement(query);
				statement.executeUpdate(query);		
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return staff;
	}
	
	
	public static String hashString(String password) throws NoSuchAlgorithmException{
		
		MessageDigest md =MessageDigest.getInstance("SHA-512");
		byte[] messageDigest = md.digest(password.getBytes());
		BigInteger bigInteger = new BigInteger(messageDigest);
		return bigInteger.toString(16);
	}
    
    
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		DBStaff dbStaff = new DBStaff();
		dbStaff.findOne("burak", "burak");
		
		
		
		
//		
		
	}

}
