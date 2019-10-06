package com.example.mani;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" },
initParams={@WebInitParam(name="defuser",value="mani")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hello from doGet");
		String uname = request.getParameter("name");
		System.out.println("The remote port is "+request.getRemotePort());
		System.out.println("The server port is "+request.getServerPort());
		System.out.println("The local port is "+request.getLocalPort());
		PrintWriter out = response.getWriter();
		if(uname==null)
			uname=getServletConfig().getInitParameter("defuser");
		out.println("<h3>Hello "+uname+"</h3>");
	}

}
