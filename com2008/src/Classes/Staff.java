package Classes;

import com2008.DBStaff;

public class Staff {
	
	
	
	private int id;
	private String username;
	private String password ;

	
	
	
	
	
	
	public Staff(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	

	public Staff(String username, String password) {

		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Staff findOne(String username, String password) {
		DBStaff dbstaff = new DBStaff();
		return dbstaff.findOne(username,password);
	}

}
