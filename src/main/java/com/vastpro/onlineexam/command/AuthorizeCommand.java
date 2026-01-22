package com.vastpro.onlineexam.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizeCommand implements Command{

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		 int role =(Integer) req.getSession().getAttribute("role");
		 	System.out.println(" AuthorizeCommand "+role);
		    if (role==1) {
		       return true;
		    } else {
		    	return false;
		    }
	}
	
	

}
