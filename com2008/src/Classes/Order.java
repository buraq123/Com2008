package Classes;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com2008.DBOrder;

public class Order {
	
	public enum Status{
		PENDING,
		CONFIRMED,
		FULFILLED
	}
	
	private int orderID;
	private LocalDateTime date;
	private int totalCost;
	private Status status;
	private Bike bike;
	private Customer customer;
	
	
	
	public static Order placeOrder(Wheel wheel,Frameset frameset,HandleBar handleBar,String productName,Customer customer) {
		Order order = new Order();
		if((customer.getId() >= 1)==false) {
			customer.save();
		}
		order.totalCost = wheel.getUnitCost()*2
				+ frameset.getUnitCost()
				+ handleBar.getUnitCost()+10;
		
		order.status = Status.PENDING;
		order.bike = new Bike(productName,handleBar,wheel,frameset);
		order.bike.save();
		order.customer = customer;
		order.date = LocalDateTime.now();
		order.save();
		return order;
	}
	
	
	
	
	private void save() {
		DBOrder dborder = new DBOrder();
		dborder.save(this);
	}
	
	
	public void confirm() {
		this.status =Status.CONFIRMED;
		this.save();
	}
	
	
	public void fulfill() {
		this.status =Status.FULFILLED;
		this.save();
	}
	
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bike getBike() {
		return this.bike;
	}
	
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	
	
//	public void delete(int orderId) {
//		Order order = Order.findOne(orderId);
//		if(order.status != Status.PENDING){
//			throw new IllegalStateException();
//		}
//		else {
//			DBOrder dborder = new DBOrder();
//			dborder.delete(orderId);
//		}
//	}
//
//
//	public static Order findOne(int orderId) {
//		DBOrder dborder = new DBOrder();
//		return dborder.findOne(orderId);
//	}
//
//
//	public static List<Order> findByCustomer(String forename, String surname, String postcode, int housenumber) {
//		DBOrder dborder = new DBOrder();
//		return dborder.findByCustomer(forename,surname,postcode,housenumber);
//	}
	
	

}
