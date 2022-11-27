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
import Classes.OrderDTO;
import Classes.OrderDTO2;

public class DBOrder {

	private DBConnection dbConnection;
	static String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String dbname = "team045";
	static String username = "team045";
	static String password = "e7b1abbe";
	
	
	
	
	public void save(Order order) {
		
		
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


	public List<OrderDTO> getPendingOrders() {
		
		
		List<OrderDTO> listOrders = new ArrayList<>();
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query =" SELECT team045.Order.idOrder,team045.Order.totalCost,team045.Order.date,team045.Wheel.serialNo,team045.Wheel.BrandName,"
						+ " team045.Frame.serialNo, team045.Frame.brandName,team045.Handlebar.serialNo,team045.Handlebar.brandName"
						+ "						FROM team045.Order \n"
						+ "						INNER JOIN team045.Bike ON team045.Order.bikeid =  team045.Bike.serialNumber\n"
						+ "						INNER JOIN team045.Wheel ON team045.Bike.wheelNo=  team045.Wheel.idWheel\n"
						+ "						INNER JOIN team045.Handlebar ON team045.Bike.HandleBarNo=  team045.Handlebar.idHandlebar\n"
						+ "						INNER JOIN team045.Frame ON team045.Bike.FrameNo=  team045.Frame.idFrame \n"
						+ "						WHERE status ='PENDING';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					OrderDTO orderDTO = new OrderDTO(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
							resultSet.getString(7),resultSet.getString(7),resultSet.getString(9));
					listOrders.add(orderDTO);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return listOrders;
	}
	
	
	
	
	
	
	
	

	public List<OrderDTO2> getConfirmedOrders() {
		
		
		List<OrderDTO2> listOrders = new ArrayList<>();
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query =" SELECT team045.Order.idOrder,team045.Order.totalCost,team045.Order.date,team045.Wheel.serialNo,team045.Wheel.BrandName,"
						+ " team045.Frame.serialNo, team045.Frame.brandName,team045.Handlebar.serialNo,team045.Handlebar.brandName,team045.Order.staffName"
						+ "						FROM team045.Order \n"
						+ "						INNER JOIN team045.Bike ON team045.Order.bikeid =  team045.Bike.serialNumber\n"
						+ "						INNER JOIN team045.Wheel ON team045.Bike.wheelNo=  team045.Wheel.idWheel\n"
						+ "						INNER JOIN team045.Handlebar ON team045.Bike.HandleBarNo=  team045.Handlebar.idHandlebar\n"
						+ "						INNER JOIN team045.Frame ON team045.Bike.FrameNo=  team045.Frame.idFrame \n"
						+ "						WHERE status ='CONFIRMED';";
				statement.execute(query);
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					OrderDTO2 orderDTO2 = new OrderDTO2(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
							resultSet.getString(7),resultSet.getString(7),resultSet.getString(9),resultSet.getString(10));
					listOrders.add(orderDTO2);
				}	
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
		return listOrders;
	}
	
	

	
	public void fulfillOrder(int id) {
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "UPDATE team045.Order SET status = 'FULFILLED'  WHERE idOrder = '"+id+"';";
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			}
			catch(SQLException e) {
				System.out.println("dadsdad");
				e.printStackTrace();
			}
		}
	}
	
	public void confirmOrder(int id,String staffName) {
		
		dbConnection = new DBConnection(dbname, username, password,url);
		boolean connected = true;
		dbConnection.connect();
		Connection conn = dbConnection.getConnection();
		
		if(conn != null) {
			try {
				Statement statement = conn.createStatement();
				String query = "UPDATE team045.Order SET status = 'CONFIRMED' , staffName = '"+staffName+"' WHERE idOrder = '"+id+"';";
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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
