package com.vastpro.onlineexam.command;


import com.vastpro.onlineexam.dao.LoginDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: LoginCommand
 *
 * Description:
 * This command class handles the login process for users.
 * 
 * It implements the Command interface and delegates the actual validation
 * of user credentials to the LoginDAO class.
 */
public class LoginCommand implements Command{

	 /**
     * Executes the login command by validating user credentials.
     *
     * @param request  the HttpServletRequest object containing the login parameters (email and password)
     * @param response the HttpServletResponse object
     * @return true if login is successful and user credentials are valid,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest request ,HttpServletResponse response) {
		return LoginDAO.validateLogin(request);
    }
	

}
