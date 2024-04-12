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
		}
		
		User u =  (User)  request.getSession().getAttribute("user");
		
		String AC = request.getParameter("ac");
		String amount = request.getParameter("amount");
		
		try {
			User r = User.getUser(AC);
			
			u.debit(amount);
			r.credit(amount);
			
			Transanction d = new Transanction(u, r, Float.parseFloat(amount), "Debit");
			Transanction c = new Transanction(r, u, Float.parseFloat(amount), "Credit");
			
			d.doTransanction();
			c.doTransanction();
			
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		
	}

}
