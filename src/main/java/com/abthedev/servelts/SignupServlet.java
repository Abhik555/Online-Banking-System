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
			
			
			User u = new User(username , password , fname , lname , email , phone , location , 0);
			u.createUser();
			
			HttpSession s = request.getSession();
			s.setAttribute("username", username);
			s.setAttribute("password", User.encryptPassword(password));
			
			request.setAttribute("status", 0);
			request.setAttribute("message", "Login Successful");
			
			request.getRequestDispatcher("/confirmpage.jsp").forward(request, response);
			
			
			
		}catch(Exception e) {
			
			request.setAttribute("status", 1);
			request.setAttribute("message", "Invalid Login Details Pls Check");
			request.getRequestDispatcher("/confirmpage.jsp").forward(request, response);
			
			r.println(e.getStackTrace());
		}
		
	}

}
