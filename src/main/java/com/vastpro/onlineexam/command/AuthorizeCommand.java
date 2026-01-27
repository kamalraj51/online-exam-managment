package com.vastpro.onlineexam.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: AuthorizeCommand
 *
 * Description:
 * This class is responsible for authorizing users based on
 * their role stored in the HTTP session.
 *
 * It allows access for admin users and restricts access
 * for non-admin users.
 */
public class AuthorizeCommand implements Command{
	
	/**
     * Executes the authorization check.
     *
     * @param req the HttpServletRequest object containing session information
     * @param res the HttpServletResponse object
     * @return true if the user is authorized (admin role),
     *         false otherwise
     */
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
