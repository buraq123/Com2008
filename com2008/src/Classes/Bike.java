package Classes;

import javax.annotation.Generated;

import com2008.DBBike;

public class Bike {
	
	
	private int bikeId;
	private String brandName;
	private String productName;
	private int quantity;
	private int unitCost;
	private int serialNumber;
	private Wheel wheel;
	private Frameset frameset;
	private HandleBar handleBar;

	
	public Bike(Wheel wheel, Frameset frameset, HandleBar handleBar, String productName) {
		this.unitCost = wheel.getUnitCost() + frameset.getUnitCost() + handleBar.getUnitCost() +10;
		this.productName = productName;
		this.brandName = " " +frameset.getBrandName()+wheel.getStyle();
		this.serialNumber = 1234;
	}

	public void save() {
		DBBike dbike = new DBBike();
		dbike.save(this);		
	}
	

	public int getId() {
		DBBike dbike = new DBBike();
		return dbike.getId(this);		
	}

	public static Bike findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
