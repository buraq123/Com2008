package Classes;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import com2008.DBStaff;

public class Staff {
	
	
	
	private int id;
	private String username;
	private String password ;

	


	public Staff(String username) {
		this.username = username;
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

	public static Staff findOne(String username, String password) throws NoSuchAlgorithmException {
		DBStaff dbstaff = new DBStaff();
		return dbstaff.findOne(username,password);
	}
}
