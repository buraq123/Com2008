package Classes;

import javax.annotation.Generated;

import com2008.DBBike;

public class Bike {
	
	
	private int serialNumber;
	private String productName;
	private String brandName;
	private int unitCost;
	private HandleBar handleBar;
	private Wheel wheel;
	private Frameset frameset;


	
	public Bike(int serialNumber, HandleBar handleBar, Wheel wheel, Frameset frameset) {
		this.serialNumber = serialNumber;
		this.handleBar = handleBar;
		this.wheel = wheel;
		this.frameset = frameset;
		this.unitCost = handleBar.getUnitCost()+wheel.getUnitCost()+frameset.getUnitCost()+10;
	}
	


	public Bike(String productName, HandleBar handleBar, Wheel wheel, Frameset frameset) {
		this.productName = productName;
		this.handleBar = handleBar;
		this.wheel = wheel;
		this.frameset = frameset;
		this.unitCost = handleBar.getUnitCost()+wheel.getUnitCost()+frameset.getUnitCost()+10;
	}




	public int getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public int getUnitCost() {
		return unitCost;
	}


	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}


	public HandleBar getHandleBar() {
		return handleBar;
	}


	public void setHandleBar(HandleBar handleBar) {
		this.handleBar = handleBar;
	}


	public Wheel getWheel() {
		return wheel;
	}


	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}


	public Frameset getFrameset() {
		return frameset;
	}


	public void setFrameset(Frameset frameset) {
		this.frameset = frameset;
	}


	public void save() {
		DBBike dbike = new DBBike();
		dbike.save(this);		
	}
	
	public static Bike findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
