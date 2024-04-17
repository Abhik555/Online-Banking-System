package com.abthedev.servelts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.abthedev.models.Transanction;
import com.abthedev.models.User;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("loginpage.jsp");
			return;
		}
		
		User u =  (User)  request.getSession().getAttribute("user");
		
		String AC = request.getParameter("ac");
		String amount = request.getParameter("amount");
		
		try {
			User r = User.getUser(AC);
			
			if(r == null) {
				request.getSession().setAttribute("status", "fstate");
				request.getSession().setAttribute("st", "Transfer Failed");
				request.getSession().setAttribute("sm", "Contact Admin for any balance related issues click the button below to return to dashboard");
				request.getSession().setAttribute("loc", "dashboard.jsp");
				response.sendRedirect("statuspage.jsp");
			}else {
			
			u.debit(amount);
			r.credit(amount);
			
			Transanction d = new Transanction(u, r, Float.parseFloat(amount+"f"), "Debit");
			Transanction c = new Transanction(r, u, Float.parseFloat(amount+"f"), "Credit");
			
			d.doTransanction();
			c.doTransanction();
			
			request.getSession().setAttribute("status", "sstate");
			request.getSession().setAttribute("st", "Transfer Successful");
			request.getSession().setAttribute("sm", "Click the button below to return to dashboard");
			request.getSession().setAttribute("loc", "dashboard.jsp");
			response.sendRedirect("statuspage.jsp");
			}
			
		}catch(Exception e) {
			
			request.getSession().setAttribute("status", "fstate");
			request.getSession().setAttribute("st", "Transfer Failed");
			request.getSession().setAttribute("sm", "Contact Admin for any balance related issues click the button below to return to dashboard");
			request.getSession().setAttribute("loc", "dashboard.jsp");
			response.sendRedirect("statuspage.jsp");
			
		}
		
		
		
		
	}

}
