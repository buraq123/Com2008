package Classes;

import java.util.List;

import com2008.DBFrameset;

public class Frameset extends Product{
	
	
	private String size;
	private Boolean shocks;
	private String gear;
	
	
	

	public Frameset(String serialNumber,String productName,String brandName,int unitCost,int quantity, String size,Boolean shocks, String gear) {
		super(serialNumber, productName, brandName, unitCost, quantity);
		this.size=size;
		this.shocks = shocks;
		this.gear = gear;
	}
	
	public Frameset(int id,String serialNumber,String productName,String brandName,int unitCost,int quantity, String size,Boolean shocks, String gear) {
		super(id,serialNumber, productName, brandName, unitCost, quantity);
		this.size=size;
		this.shocks = shocks;
		this.gear = gear;
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
	
	public static List<Frameset> getAll() {
		DBFrameset dbFrameset = new DBFrameset();
		return dbFrameset.getAll();
	}



	public static Frameset findOne(int id) {
		DBFrameset dbFrameset = new DBFrameset();
		return dbFrameset.findOne(id);
	}

	public void updateStock() {
		DBFrameset dbFrameset = new DBFrameset();
		dbFrameset.updateStock(this);
		
	}

	public static Frameset findOne(String serialNumber, String brandName) {
		DBFrameset dbFrameset = new DBFrameset();
		return dbFrameset.findOne(serialNumber,brandName);
	}

	public void save() {
		DBFrameset dbFrameset = new DBFrameset();
		dbFrameset.save(this);
		
	}
	
	
	
	

	
	

}
