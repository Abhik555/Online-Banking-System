package com.abthedev.servelts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class LogoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("status", "sstate");
			request.getSession().setAttribute("st", "Logout Successful");
			request.getSession().setAttribute("sm", "Click the button below to return to home page");
			request.getSession().setAttribute("loc", "index.jsp");
			response.sendRedirect("statuspage.jsp");
			
		}catch(Exception e) {
			request.getSession().setAttribute("status", "fstate");
			request.getSession().setAttribute("st", "Logout Failed");
			request.getSession().setAttribute("sm", "Click the button below to return to dashboard");
			request.getSession().setAttribute("loc", "dashboard.jsp");
			response.sendRedirect("statuspage.jsp");
		}
	}

}
