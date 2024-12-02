package com.demo.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "crudServlet", urlPatterns = { "/Crud" })
public class crud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btn");
		switch (btn){
		case "add": {
			RequestDispatcher rD=request.getRequestDispatcher("AddAccount.html");
			rD.forward(request, response);
			
		}
		case "del": {
			RequestDispatcher rD=request.getRequestDispatcher("DelAccount.htm");
			rD.forward(request, response);
			
		}
		case "display": {
			RequestDispatcher rD=request.getRequestDispatcher("displayServlet");
			rD.forward(request, response);
			
		}
		case "wd": {
			RequestDispatcher rD=request.getRequestDispatcher("withdraw.html");
			rD.forward(request, response);
			
		}
		case "diop": {
			RequestDispatcher rD=request.getRequestDispatcher("deposite.html");
			rD.forward(request, response);
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + btn);
		}
	}

}
