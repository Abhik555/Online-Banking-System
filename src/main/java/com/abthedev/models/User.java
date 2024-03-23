package com.abthedev.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

	private String username;
	private int AccountID;
	private String password;
	private String fname, lname, email, location, phone;

	private String url = "jdbc:mysql://localhost:3306/jbank";
	private String usernamedb = "root";
	private String passworddb = "abhik";
	private String tablename = "accounts";

	private boolean isCreate;

	public User(String username, String password, String fname, String lname, String email, String phone,
			String location) {
		this.username = username;
		this.password =  encryptPassword(password);
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.location = location;
		this.phone = phone;
		this.isCreate = true;

	}

	public User(String AccountID) {
		this.isCreate = false;
	}

	public void login() {

	}

	public void logout() {

	}

	public void createUser() {
		if (!this.isCreate) {
			return;
		}

		try {
			Connection conn = DriverManager.getConnection(url, usernamedb, passworddb);

			// Getting new Account ID
			String accq = "select * from accounts";
			Statement s = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
					java.sql.ResultSet.CONCUR_READ_ONLY);
			ResultSet rd = s.executeQuery(accq);
			rd.last();
			this.AccountID = rd.getInt(1) + 1;

			// Creating User In Database
			String addstatemnt = "insert into " + tablename + " values(" +this.AccountID + "," + this.username + ","
					+ this.password + "," + this.fname + "," + this.lname + "," + this.email + "," + this.phone + ","
					+ this.location + ")";
			
			PreparedStatement cu = conn.prepareStatement("INSERT INTO ACCOUNTS VALUES(? , ? , ? , ? ,? ,?,?,?)");
			cu.setInt(1, this.AccountID);
			cu.setString(2, username);
			cu.setString(3, password);
			cu.setString(4, fname);
			cu.setString(5, lname);
			cu.setString(6, email);
			cu.setString(7, phone);
			cu.setString(8, location);
			
			cu.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encryptPassword(String password) {
		StringBuilder b = new StringBuilder(password.length());
		for (int i = 0; i < password.length(); i++) {

			char c = (char) ((int) password.charAt(i) + Math.pow(2, i));
			b.append(c);

		}
		return b.toString();
	}

	public static String deencryptPassword(String password) {
		StringBuilder b = new StringBuilder(password.length());
		for (int i = 0; i < password.length(); i++) {

			char c = (char) ((int) password.charAt(i) - Math.pow(2, i));
			b.append(c);

		}

		return b.toString();
	}
	
	public static User getUser(String AccountID) {
		return new User(AccountID);
	}
}
