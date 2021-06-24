package com.dell.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.sendRedirect("register.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		String password = request.getParameter("password");		
		String cnfPassword = request.getParameter("cnfPassword");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		if(!userName.equals("") && !userEmail.equals("") && !password.equals("")) {
			if(cnfPassword.equalsIgnoreCase(password)) {
				out.println("<h1 style='color:green'>Registration sucessfull ! for user '"+userName+"' </h1>");
			} else {
				out.println("<h1 style='color:red'>Registration Failed  *Miss Match Password </h1>");
			}			
		} else {
			out.println("<h1 style='color:red'>Registration Failed  * Required filled are missing! </h1>");
		}	
		
	}

}
