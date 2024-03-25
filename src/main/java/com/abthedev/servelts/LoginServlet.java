package com.abthedev.servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.abthedev.DatabaseUtils;
import com.abthedev.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static Connection conn = new DatabaseUtils().getConnection();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter r = response.getWriter();
		String accid = request.getParameter("accountid");
		String pass = request.getParameter("password");
		
		try {
			
			User u = User.login(accid, pass);
			r.println(u.getUsername());
			r.println(u.getFname());
			r.println(u.getLname());
			r.println(u.getEmail());
			r.println(u.getLocation());
			r.println(u.getPhone());
			r.println(u.getBalance());
			
			u.credit("100");
			r.println(u.getBalance());
			u.debit("50");
			r.println(u.getBalance());
			
		}catch(Exception e) {
			
		}
//		
//		String url = "jdbc:mysql://localhost:3306/jbank";
//		String username = "root";
//		String password = "abhik";
//		
//		
//		try {
//			Connection conn = DriverManager.getConnection(url, username, password);
//			r.println(conn.getTypeMap());
//		}catch(Exception e) {
//			r.println(e.getMessage());
//		}
		
	}

}
