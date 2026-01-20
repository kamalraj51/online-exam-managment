package com.vastpro.onlineexam.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizeCommand implements Command{

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		 String role = req.getParameter("role");
		 	System.out.println(role);
		    if ("1".equals(role)) {
		       return true;
		    } else {
		    	return false;
		    }
		 // return true;
	}
	
	

}
