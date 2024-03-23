package com.abthedev.servelts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testclass {
	
	private static String url = "jdbc:mysql://localhost:3306/jbank";
	private static  String usernamedb = "root";
	private static String passworddb = "abhik";
	private static long accountid = 1;
	
	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection(url, usernamedb, passworddb);
			String accq = "select * from accounts";
			Statement s = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE , java.sql.ResultSet.CONCUR_READ_ONLY);
			ResultSet rd =  s.executeQuery(accq);
			rd.last();
			accountid *= (long) rd.getInt(1);
			System.out.println(accountid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
