package Classes;

import java.util.List;

public class Frameset extends Product{
	
	
	private String size;
	private Boolean shocks;
	private String gear;
	
	
	

	public Frameset(String serialNumber,String productName,String brandName,int unitCost,int quantity, String size,Boolean shocks, String gear) {
		super(serialNumber, productName, brandName, unitCost, quantity);
		this.shocks = shocks;
		this.gear = gear;
	}

	
	public static List<Frameset> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Boolean getShocks() {
		return shocks;
	}


	public void setShocks(Boolean shocks) {
		this.shocks = shocks;
	}


	public String getGear() {
		return gear;
	}

	public static Frameset findOne() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
