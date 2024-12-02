package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.dao.ValidateDao;
import com.demo.service.Validate;
import com.demo.service.ValidateServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/validate")
public class validateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    String uname=request.getParameter("uname");
	    String password=request.getParameter("password");
	    Validate vser=new ValidateServiceImpl();
	    MyUser m1=vser.Authenticate(uname,password);
	    if(m1!=null && m1.getRole().equals("admin")) {
	    	//out.print("Successfully LoggedIn");
	    	RequestDispatcher rd=request.getRequestDispatcher("ShowAcc.html");
	    	rd.forward(request, response);
	    }
	    else {
			out.print("Not login");
		}
		
		
		
	}

	

}
