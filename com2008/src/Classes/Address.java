package Classes;

import com2008.DBAddress;

public class Address {
	
	private int id;
	private String houseNumber;
	private String postcode;
	private String cityName;
	private String roadName;
	
	
	
	
	public Address(int id, String houseNumber, String postcode, String cityName, String roadName) {
		this.id = id;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.cityName = cityName;
		this.roadName = roadName;
	}
	
	public Address(String houseNumber, String postcode, String cityName, String roadName) {
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.cityName = cityName;
		this.roadName = roadName;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public static Address findOne(String houseNumber,String postcode) {
		DBAddress dbadress = new DBAddress();
		return dbadress.findOne(houseNumber,postcode);
		
	}

	public void save() {
		DBAddress dbadress = new DBAddress();
		dbadress.save(this);
	}
}
