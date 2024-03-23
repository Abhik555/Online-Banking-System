package com.abthedev.servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter r = response.getWriter();
		String accid = request.getParameter("accountid");
		String pass = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/jbank";
		String username = "root";
		String password = "abhik";
		
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			r.println(conn.getTypeMap());
		}catch(Exception e) {
			r.println(e.getMessage());
		}
		
	}

}
