package com.abthedev.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.UUID;

import com.abthedev.DatabaseUtils;

public class Transanction {
	
	
	private String TransanctionID;
	private int SenderID;
	private int ReceiverID;
	private float Amount;
	private String Type;
	private String sender_username , reciever_username; 
	private String Date;
	//private User sender , reciever;
	
	private static Connection conn = new DatabaseUtils().getConnection();
	
	public Transanction(User sender , User reciever , float Amount , String Type) {
		this.SenderID = sender.getAccountID();
		this.ReceiverID = reciever.getAccountID();
		this.Amount = Amount;
		this.Type = Type;
		this.sender_username = sender.getUsername();
		this.reciever_username = reciever.getUsername();
		this.TransanctionID = UUID.randomUUID().toString();
		//this.sender = sender;
		//this.reciever = reciever;
		
		
	}
	
	public void doTransanction() {
		
		this.Date = LocalDateTime.now().toString();
		try {
			
			PreparedStatement s = conn.prepareStatement("insert into transanction values(?,?,?,?,?,?,?,?)");
			s.setString(1, this.TransanctionID);
			s.setInt(2,this.SenderID);
			s.setString(3, this.sender_username);
			s.setInt(4, this.ReceiverID);
			s.setString(5, this.reciever_username);
			s.setFloat(6, this.Amount);
			s.setString(7, this.Date);
			s.setString(8, this.Type);
			
			s.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<ArrayList<String>> getUserTransanctions(User u){
		
		try {
			
			PreparedStatement s = conn.prepareStatement("select * from transanction where ACCOUNTID = ?");
			s.setString(1, String.valueOf(u.getAccountID()));
			ResultSet r =  s.executeQuery();
			
			//Creating ArrayList
			int col = r.getMetaData().getColumnCount();
			
			ArrayList<ArrayList<String>> out = new ArrayList<>();
			
			while(r.next()) {
				int i = 1;
				ArrayList<String> g = new ArrayList<>();
				while(i <= col) {
					g.add(r.getString(i++));
				}
				out.add(g);
			}
			
			return out;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
