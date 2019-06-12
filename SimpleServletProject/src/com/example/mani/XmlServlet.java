package com.example.mani;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println("Inside doGet method of  XmlServlet");
		String userName = req.getParameter("username");
		HttpSession session = req.getSession();
		ServletContext context = req.getServletContext();
		if(userName!="" && userName!=null) {
			session.setAttribute("name", userName);
			context.setAttribute("name", userName);
		}
		PrintWriter out = resp.getWriter();
		out.println("The username from request is "+userName);
		out.println("The username from session is "+ (String)session.getAttribute("name"));
		out.println("The username from context is "+ (String)context.getAttribute("name"));
		out.println("The username from servlet config  is "+ getServletConfig().getInitParameter("defuser"));
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println("Inside doPost method of  XmlServlet");
		String userName = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		String fullName = req.getParameter("fullname");
		String prof = req.getParameter("prof");
		String[] loc = req.getParameterValues("loc");
		out.write("Hello "+userName+"! Your fullname is "+fullName+" And you are a "+prof);
		out.println(". You reside at "+loc.length+" And They are : ");
		for(String s: loc)
			out.println(s);
		
		
	}


}
