package com2008;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Classes.Bike;
import Classes.Order;

public class DBOrder {

	private DBConnection dbConnection;
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	
	
	
	
	public void save(Order order) {
		
	}

	public Order findOne(int orderId) {
		Order order  = createOrderFromResultSet(resultSet);
		return order;
		// TODO Auto-generated method stub
		
	}

	public List<Order> findByCustomer(String forename, String surname, String postcode, int housenumber) {
		List<Order> orders =new ArrayList<>();
		// TODO Auto-generated method stub
		while(resultSet.next()) {
			orders.add(createOrderFromResultSet(resultSet));
		}
		return null;
	}
	
	private Order createOrderFromResultSet(ResultSet resultset) {
		Order order = new Order();
		Bike bike =Bike.findOne(result.id);
		order.setBike(bike);
		return order;
	
	}

	public void delete(int orderId) {
		// TODO Auto-generated method stub
		
	}

}
