package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Xml Servlet has been called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(userName!=null && userName!="") {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}		
		out.println("Hello "+userName);
		out.println("Hello from session "+ session.getAttribute("savedUserName"));
		out.println("Hello from context "+ context.getAttribute("savedUserName"));
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Xml Servlet has been called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		out.println("Hello from do post method "+userName+" and the full name "+fullName);
		String prof = request.getParameter("prof");
		out.println("You are a "+prof);
		String[] location = request.getParameterValues("location");
		for(int i=0;i<location.length;i++)
		out.println(location[i]);
		System.getProperties();
	}
}
