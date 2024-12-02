package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.service.CRUD;
import com.demo.service.CRUDImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addAccount")
public class addAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int aid=Integer.parseInt(request.getParameter("aid"));
		String aname=request.getParameter("aname");
		int bl=Integer.parseInt(request.getParameter("bl"));
		CRUD cservice=new CRUDImpl();
		int n =cservice.addAccount(aid,aname,bl);
		if(n!=-1)
		{
			out.print("Succesfully Addded!!!");
		}
		else {
			out.print("Not Added!!!");
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
