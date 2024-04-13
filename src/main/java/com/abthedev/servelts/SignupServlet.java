package com.abthedev.servelts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import com.abthedev.models.User;

/**
 * Servlet implementation class SignupServlet
 */

@WebServlet("/register")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter r = response.getWriter();
		
		
		try {
			
			String username = request.getParameter("username");
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String location = request.getParameter("location");
			
			
			User u = new User(username , password , fname , lname , email , phone , location , 100);
			u.createUser();
			
			HttpSession s = request.getSession();
			s.setAttribute("user", u);
			
			request.setAttribute("status", 0);
			request.setAttribute("message", "Login Successful");
			
			request.getSession().setAttribute("status", "sstate");
			request.getSession().setAttribute("st", "Created Account Successfully");
			request.getSession().setAttribute("sm", "Your Account Number is: "+u.getAccountID());
			request.getSession().setAttribute("loc", "dashboard.jsp");
			response.sendRedirect("statuspage.jsp");
			
			
		}catch(Exception e) {
			
			request.getSession().setAttribute("status", "fstate");
			request.getSession().setAttribute("st", "Account Creation Failed");
			request.getSession().setAttribute("sm", "Contact Admin for assistance click the button below to return to homepage");
			request.getSession().setAttribute("loc", "index.jsp");
			response.sendRedirect("statuspage.jsp");
			
		}
		
	}

}
