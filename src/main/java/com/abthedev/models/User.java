package com.abthedev.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abthedev.DatabaseUtils;

public class User {

	private String username;
	private int AccountID;
	private float Balance;
	private String password;
	private String fname, lname, email, location, phone;

	private static Connection conn = new DatabaseUtils().getConnection();

	private boolean isCreate;

	// Constructor For Creating Account
	public User(String username, String password, String fname, String lname, String email, String phone,
			String location, int Balance) {
		this.username = username;
		this.password = encryptPassword(password);
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.location = location;
		this.phone = phone;
		this.Balance = Balance;
		this.isCreate = true;

	}

	// Constructor for login
	public User(int AccountID, String username, String password, String fname, String lname, String email, String phone,
			String location, float Balance) {
		this.AccountID = AccountID;
		this.username = username;
		this.password = encryptPassword(password);
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.location = location;
		this.phone = phone;
		this.Balance = Balance;
		this.isCreate = true;

	}

	public User(String AccountID) {
		this.isCreate = false;
	}

	public static User login(String AccountID, String password) {

		try {
			PreparedStatement gs = conn.prepareStatement("select * from accounts where ACCOUNTID = ?",
					java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
			gs.setString(1, AccountID);
			ResultSet r = gs.executeQuery();
			r.first();
			String pass = deencryptPassword(r.getString(3));

			if (pass.equals(password)) {

				String uname = r.getString(2);
				String fname = r.getString(4);
				String lname = r.getString(5);
				String email = r.getString(6);
				String phone = r.getString(7);
				String addr = r.getString(8);
				int bal = r.getInt(9);

				return new User(Integer.parseInt(AccountID), uname, password, fname, lname, email, phone, addr, bal);

			} else {

				return null;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void createUser() {
		if (!this.isCreate) {
			return;
		}

		try {

			// Getting new Account ID
			String accq = "select * from accounts";
			Statement s = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
					java.sql.ResultSet.CONCUR_READ_ONLY);
			ResultSet rd = s.executeQuery(accq);
			rd.last();
			this.AccountID = rd.getInt(1) + 1;

			PreparedStatement cu = conn.prepareStatement("INSERT INTO ACCOUNTS VALUES(? , ? , ? , ? ,? ,?,?,?,?)");
			cu.setInt(1, this.AccountID);
			cu.setString(2, username);
			cu.setString(3, password);
			cu.setString(4, fname);
			cu.setString(5, lname);
			cu.setString(6, email);
			cu.setString(7, phone);
			cu.setString(8, location);
			cu.setFloat(9, Balance);

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
		
		try {
			PreparedStatement s = conn.prepareStatement("select * from accounts where ACCOUNTID = ?" , java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
			s.setString(1, AccountID);
			ResultSet r = s.executeQuery();
			r.first();
			
			String pass = deencryptPassword(r.getString(3));
			
			String uname = r.getString(2);
			String fname = r.getString(4);
			String lname = r.getString(5);
			String email = r.getString(6);
			String phone = r.getString(7);
			String addr = r.getString(8);
			int bal = r.getInt(9);

			return new User(Integer.parseInt(AccountID), uname, pass, fname, lname, email, phone, addr, bal);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int credit(String Amount) {

		PreparedStatement s;
		try {
			s = conn.prepareStatement("UPDATE ACCOUNTS SET BALANCE = BALANCE + ? WHERE ACCOUNTID = ?");
			s.setString(1, Amount);
			s.setString(2, String.valueOf(this.AccountID));
			s.execute();
			
			this.Balance = this.Balance + Integer.parseInt(Amount);

			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}

	public int debit(String Amount) {

		PreparedStatement s;
		try {
			s = conn.prepareStatement("UPDATE ACCOUNTS SET BALANCE = BALANCE - ? WHERE ACCOUNTID = ?");
			s.setString(1, Amount);
			s.setString(2, String.valueOf(this.AccountID));
			s.execute();
			
			this.Balance = this.Balance - Integer.parseInt(Amount);

			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}

	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return AccountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	/**
	 * @return the balance
	 */
	public float getBalance() {
		return Balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		Balance = balance;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
