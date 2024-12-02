package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.service.CRUD;
import com.demo.service.CRUDImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deposite")
public class deposite extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount=Double.parseDouble(request.getParameter("amt"));
		int id=Integer.parseInt(request.getParameter("aid"));
	        
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        CRUD cservice=new CRUDImpl();
	        boolean status=cservice.deposite(amount,id);
	        if(status)
	        {
	        	out.print("Successfully Deposited!!");
	        	
	        }
	        else {
	        	out.print("Not Deposited!!");
			}
	}

}
