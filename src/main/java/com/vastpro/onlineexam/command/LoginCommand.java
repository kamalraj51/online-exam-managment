package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.LoginDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: LoginCommand
 *
 * Description: This command class handles the login process for users.
 * 
 * It implements the Command interface and delegates the actual validation of user credentials to the LoginDAO class.
 */
public class LoginCommand implements Command {

	/**
	 * Executes the login command by validating user credentials.
	 *
	 * @param request
	 *            the HttpServletRequest object containing the login parameters (email and password)
	 * @param response
	 *            the HttpServletResponse object
	 * @return true if login is successful and user credentials are valid, false otherwise
	 */
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");

		String password = request.getParameter("password");

		// Email validation (only Gmail allowed)
		if (email == "") {

			request.setAttribute("emailError", "Email cannot be empty.");
			return false;
		}
		if (!email.matches(" ^[^\\s@]+@[^.\\s@]*[a-zA-Z][^.\\s@]*\\.[a-zA-Z]{2,}$")) { 

			request.setAttribute("emailError", "Invalid email.Enter a valid email address.");
			return false;
		}

		// Password validation (min 8 chars, uppercase, lowercase, number)
		if (password == null) {
			request.setAttribute("passwordError", "Password must be at least 8 characters long.");
			return false;
		}

		return LoginDAO.validateLogin(request);
	}

}
