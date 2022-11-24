package Classes;

import java.util.List;

import com2008.DBHandleBar;

public class HandleBar {
	
	public enum Style{
		HIGH,
		STRAIGHT,
		DROPPED
	}
	
	private String brandName;
	private String productName;
	private int quantity;
	private int unitCost;
	private int serialNumber;
	private Style style;
	
	
	public HandleBar(String brandName, String productName, int quantity, int unitCost, int serialNumber, Style style) {
		super();
		this.brandName = brandName;
		this.productName = productName;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.serialNumber = serialNumber;
		this.style = style;
	}
	
	

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	
	public void save() {
		if (findOne(this.serialNumber, brandName) != null) {
			throw new IllegalArgumentException("product already exixts");	
		}
		else {
			DBHandleBar dbHandleBar = new DBHandleBar();
			dbHandleBar.save(this);	
		}
	}
	
	public static HandleBar findOne(int seiralNo, String brandName){
		DBHandleBar dbHandleBar = new DBHandleBar();
		return dbHandleBar.findOne(seiralNo,brandName);
		
	}
	
	public void addToStock(int quantity) {
		DBHandleBar dbHandleBar = new DBHandleBar();
		this.setQuantity(this.quantity+quantity);
		dbHandleBar.update(this);
	}
	
	public void removeFromStock(int quantity) {
		DBHandleBar dbHandleBar = new DBHandleBar();
		if(this.quantity >= quantity) {
			this.setQuantity(this.quantity-quantity);
			dbHandleBar.update(this);
		}
		else {
			throw new IllegalStateException(String.format("Not enough stock current stock :%s Removed quantity %s",this.quantity,quantity));
		}
	}



	public static List<HandleBar> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
