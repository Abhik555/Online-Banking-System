package com.abthedev;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {
	
	
	private Connection conn;
	
	//Credentials
	private String url = "jdbc:mysql://localhost:3306/jbank";
	private String usernamedb = "root";
	private String passworddb = "abhik";
	
	public DatabaseUtils() {
		
		try {
			conn = DriverManager.getConnection(url, usernamedb, passworddb);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {return conn;}
	

}
