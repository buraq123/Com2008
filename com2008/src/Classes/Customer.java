package Classes;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com2008.DBCustomer;

public class Customer {
	
	private int id;
	private String forename;
	private String surname;
	private Address address;
	
	
	
	

	public Customer(String forename, String surname, Address address) {
		this.forename = forename;
		this.surname = surname;
		if((address.getId() >= 1)== false) {
			address.save();
		}
		this.address = address;
		
	}

	public Customer(int id, String forename, String surname, Address address) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.address = address;
	}
	
	
	

	public void save() {
		DBCustomer dbCustomer = new DBCustomer ();
		dbCustomer.save(this);	
	}
	
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static Customer findOne(String forename, String surname, String postcode, String housenumber) {
		DBCustomer dbCustomer = new DBCustomer();
		return dbCustomer.findOne(forename,surname,postcode,housenumber);
		
	}
	
	
	public void update() {
		DBCustomer dbcustomer = new DBCustomer();
		dbcustomer.update(this);	
	}

	

}
