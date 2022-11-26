package com2008;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Address;
import Classes.Customer;
import Classes.Frameset;

public class DBCustomer {
	
private DBConnection dbConnection;
	
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public Customer findOne(String forename, String surname, String postcode, String housenumber) {
		
		Address address = null;
		Customer customer = null;
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM team045.Customer INNER JOIN team045.Address ON team045.Customer.address = team045.Address.idAddress "
						+ "WHERE forename = '"+forename+"' AND surname= '"+surname+"' AND postcode= '"+postcode+"' AND houseNumber = '"+housenumber+"';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					address = new Address(Integer.valueOf(resultSet.getString(5)),resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),resultSet.getString(9));
					customer = new Customer(Integer.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),address);
				}
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return customer;
	}

	public void save(Customer customer) {
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "INSERT INTO team045.Customer (forename,surname,address) VALUES "
						+ "('"+customer.getForename()+"','"+customer.getSurname()+"','"+customer.getAddress().getId()+"');";
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					customer.setId(id);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {		
//		DBCustomer  dbCustomer = new DBCustomer();
//		System.out.print(dbCustomer.findOne("burak", "akdeniz", "sm1", "2"));	
//	}
	
	

}
