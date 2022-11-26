package Classes;

import java.util.List;

import com2008.DBHandleBar;

public class HandleBar  extends Product{
	
	public enum Style{
		HIGH,
		STRAIGHT,
		DROPPED
	}
	
	
	private Style style;
	
	
	
	public HandleBar(String serialNumber, String productName, String brandName, int unitCost, int quantity,Style style) {
		super(serialNumber, productName, brandName, unitCost, quantity);
		this.style = style;
	}

	public HandleBar(int id,String serialNumber,String productName,String brandName, int unitCost, int quantity,Style style) {
		super(id,serialNumber, productName, brandName, unitCost, quantity);
		this.style = style;
	}
	


	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}





	public void save() {
		if (findOne(this.getId()) != null) {
			throw new IllegalArgumentException("product already exixts");	
		}
		else {
			DBHandleBar dbHandleBar = new DBHandleBar();
			dbHandleBar.save(this);	
		}
	}
	
//	public static HandleBar findOne(String seiralNo, String brandName){
//		DBHandleBar dbHandleBar = new DBHandleBar();
//		return dbHandleBar.findOne(seiralNo,brandName);
//		
//	}
	
	public void addToStock(int quantity) {
		DBHandleBar dbHandleBar = new DBHandleBar();
		this.setQuantity(this.getQuantity()+quantity);
		dbHandleBar.update(this);
	}
	
	
	
	
	public void removeFromStock(int quantity) {
		DBHandleBar dbHandleBar = new DBHandleBar();
		if(this.getQuantity() >= quantity) {
			this.setQuantity(this.getQuantity()-quantity);
			dbHandleBar.update(this);
		}
		else {
			throw new IllegalStateException(String.format("Not enough stock current stock :%s Removed quantity %s",this.getQuantity(),quantity));
		}
	}

	public static List<HandleBar> getAll() {
		DBHandleBar dbHandleBar = new DBHandleBar();
		return dbHandleBar.findAll();
		
	}



	public static HandleBar findOne(int handlebarId) {
		DBHandleBar dbHandleBar =new DBHandleBar();
		return dbHandleBar.findOne(handlebarId);
	}




	
}
