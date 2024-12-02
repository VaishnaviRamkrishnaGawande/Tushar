package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.demo.beans.MyAccount;
import com.demo.service.CRUD;
import com.demo.service.CRUDImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/displayServlet")
public class displayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		CRUD cservice=new CRUDImpl();
		List<MyAccount>acc=cservice.displayALL();
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		    out.println("<head><title>Account List</title></head>");
		    out.println("<body>");
		    out.println("<h1>Account List</h1>");
		    out.println("<table border='1'>");
		    out.println("<tr><th>Account ID</th><th>Account Name</th><th>Account Balance</th></tr>");
		    
		   
		    for (MyAccount account : acc) {
		        out.println("<tr>");
		        out.println("<td>" + account.getAid() + "</td>"); // assuming getId() method exists
		        out.println("<td>" + account.getAname() + "</td>"); // assuming getName() method exists
		        out.println("<td>" + account.getBal() + "</td>"); // assuming getBalance() method exists
		        out.println("</tr>");
		    }
		    
		    out.println("</table>");
		    out.println("</body>");
		    out.println("</html>");
		
		
	}

}
