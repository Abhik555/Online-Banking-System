package com.abthedev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtils {
	
	
	private Connection conn;
	
	//Credentials
	private static String url = "jdbc:mysql://localhost:3306/jbank";
	private static String usernamedb = "root";
	private static String passworddb = "abhik";
	
	public DatabaseUtils() {
		
		try {
			conn = DriverManager.getConnection(url, usernamedb, passworddb);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {return conn;}
	
	
	public static void checkDatabase() {
		
		String url1 = "jdbc:mysql://localhost:3306/";
		
		try {
			Connection conn = DriverManager.getConnection(url1, usernamedb, passworddb);
			boolean exist = false;
			ResultSet r = conn.getMetaData().getCatalogs();
			
			while(r.next()) {
				
				if(r.getString(1).equals("jbank")){
					exist = true;
				}
				
			}
			
			if(!exist) {
				
				PreparedStatement s = conn.prepareStatement("CREATE DATABASE jbank");
				s.execute();
				PreparedStatement s2 = conn.prepareStatement("USE jbank");
				s2.execute();
				
				PreparedStatement ct1 = conn.prepareStatement("CREATE TABLE ACCOUNTS(ACCOUNTID INTEGER(255) PRIMARY KEY , USERNAME VARCHAR(100) UNIQUE , PASSWORD VARCHAR(500) , FIRSTNAME VARCHAR(50) , LASTNAME VARCHAR(50) , EMAIL VARCHAR(100) , PHONENUMBER VARCHAR(100) , ADDRESS VARCHAR(5000) , BALANCE FLOAT)");
				PreparedStatement ct2 = conn.prepareStatement("CREATE TABLE TRANSANCTION(TRANSANCTIONID VARCHAR(500) PRIMARY KEY , ACCOUNTID INTEGER(255) , SENDERUDERNAME VARCHAR(500) , RECEIVERID INTEGER(255) , RECEIVERUSERNAME VARCHAR(500) , amount FLOAT , timestamp VARCHAR(500) , TYPE VARCHAR(50))");
				ct1.execute();
				ct2.execute();
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
