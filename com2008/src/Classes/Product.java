package Classes;

public class Product {
	
	private int id;
	private String serialNumber;
	private String productName;
	private String brandName;
	private int unitCost;
	private int quantity;
	
	
	public Product(String serialNumber, String productName, String brandName, int unitCost, int quantity) {
		super();
		this.serialNumber = serialNumber;
		this.productName = productName;
		this.brandName = brandName;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}
	
	
	
	
	public Product(int id, String serialNumber, String productName, String brandName, int unitCost, int quantity) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.productName = productName;
		this.brandName = brandName;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
	
	
	
	
	

}
