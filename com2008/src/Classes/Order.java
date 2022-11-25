package Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com2008.DBOrder;

public class Order {
	List<Product> products = new ArrayList<>();
	
	public enum Status{
		PENDING,
		CONFIRMED,
		FULFILLED
	}
	
	private int orderID;
	private LocalDateTime date;
	private Bike bike;
	private int totalCost;
	private Status status;
	private Customer customer;
	
	
	public Bike getBike() {
		return this.bike;
	}
	
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	
	public static Order placeOrder(Wheel wheel,Frameset frameset,HandleBar handleBar,String productName,Customer customer) {
		customer.save();
		return placeOrder(wheel,frameset,handleBar,productName,customer.getId());
	}
	
	
	public static Order placeOrder(Wheel wheel,Frameset frameset,HandleBar handleBar,String producName, int customerId) {
		Order order = new Order();
		order.totalCost = wheel.getUnitCost()*2
				+ frameset.getUnitCost()
				+ handleBar.getUnitCost();
		
		order.status = Status.PENDING;
		order.bike = new Bike(wheel,frameset,handleBar,producName);
		order.bike.save();
		
		
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
	
	
	public void delete(int orderId) {
		Order order = Order.findOne(orderId);
		if(order.status != Status.PENDING){
			throw new IllegalStateException();
		}
		else {
			DBOrder dborder = new DBOrder();
			dborder.delete(orderId);
		}
	}


	public static Order findOne(int orderId) {
		DBOrder dborder = new DBOrder();
		return dborder.findOne(orderId);
	}


	public static List<Order> findByCustomer(String forename, String surname, String postcode, int housenumber) {
		DBOrder dborder = new DBOrder();
		return dborder.findByCustomer(forename,surname,postcode,housenumber);
	}
	
	

}
