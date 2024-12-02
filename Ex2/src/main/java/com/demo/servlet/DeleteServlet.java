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


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		int id=Integer.parseInt(request.getParameter("del"));
		CRUD cservice=new CRUDImpl();
		int n =cservice.delAcc(id);
		if(n!=-1)
		{
			out.println("Succesfully Deleted!!!");
			RequestDispatcher rD=request.getRequestDispatcher("ShowAcc.html");
			rD.forward(request, response);
		}
		else {
			out.print("Not Found!!!");
		}
		 
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
