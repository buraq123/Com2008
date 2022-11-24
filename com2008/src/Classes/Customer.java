package Classes;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com2008.DBCustomer;

public class Customer {
	
	private int id;
	private String forename;
	private String surname;
	private Address address;
	

	public void save() {
		
		
		// TODO Auto-generated method stub
		
	}

	public int  getId() {
		 
		// TODO Auto-generated method stub
		return 0;
	}

	public static Customer findOne(String forename, String surname, String postcode, String housenumber) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void update() {
		DBCustomer dbcustomer = new DBCustomer();
		dbcustomer.update(this);	
	}
	

}
