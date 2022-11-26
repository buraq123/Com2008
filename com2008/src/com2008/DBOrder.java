package com2008;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Classes.Bike;
import Classes.Customer;
import Classes.Order;
import Classes.Order.Status;

public class DBOrder {

	private DBConnection dbConnection;
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	
	
	
	
	public void save(Order order) {
		
		System.out.println(order.getDate());
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "INSERT INTO team045.Order (date,totalCost,status,bikeid,customerid) VALUES "
						+ "('"+order.getDate()+"','"+order.getTotalCost()+"','"+order.getStatus()+"','"+order.getBike().getSerialNumber()+"','"+order.getCustomer().getId()+"');";
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int id = resultSet.getInt(1);
					order.setOrderID(id);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}

//	public Order findOne(int orderId) {
//		Order order  = createOrderFromResultSet(resultSet);
//		return order;
//		// TODO Auto-generated method stub
//		
//	}
//
//	public List<Order> findByCustomer(String forename, String surname, String postcode, int housenumber) {
//		List<Order> orders =new ArrayList<>();
//		// TODO Auto-generated method stub
//		while(resultSet.next()) {
//			orders.add(createOrderFromResultSet(resultSet));
//		}
//		return null;
//	}
//	
//	private Order createOrderFromResultSet(ResultSet resultset) {
//		Order order = new Order();
//		Bike bike =Bike.findOne(result.id);
//		order.setBike(bike);
//		return order;
//	
//	}
//
//	public void delete(int orderId) {
//		// TODO Auto-generated method stub
//		
//	}

}
