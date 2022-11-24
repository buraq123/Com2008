package com2008;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private String dbname,username,password,url;
	private Connection conn =null;
	
	public DBConnection (String dbname,String username,String password,String url) {
		super();
		this.dbname = dbname;
		this.username =username;
		this.password = password;
		this.url = url;
	}
	
	public boolean connect() {
		boolean connected =true;
		if(conn==null) {
			try {
				conn = DriverManager.getConnection(url+dbname,username,password);
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				connected = false;
			}
		}
		return connected;
	}
	
	public void disconnect(){
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	
	
	
}
