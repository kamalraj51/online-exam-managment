package com.vastpro.onlineexam.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if (email == null || !isValidEmail(email)) {
			request.setAttribute("emailError", "Invalid email.Enter a valid email address.");
			return false;
		}

		// Password validation (allow letters, numbers, and special characters with a minimum length of 6)
		if (password == null) {
			request.setAttribute("passwordError", "Password must be at least 6 characters long");
			return false;
		}

		return LoginDAO.validateLogin(request);
	}

	// Helper method for email validation (only Gmail)
	private boolean isValidEmail(String email) {
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		Matcher matcher = emailPattern.matcher(email);
		return matcher.matches();
	}

	// Helper method for password validation (letters, numbers, special characters, minimum length of 6)
	private boolean isValidPassword(String password) {
		Pattern passwordPattern = Pattern.compile("^[\\S]{6,}$");
		Matcher matcher = passwordPattern.matcher(password);
		return matcher.matches();
	}

}
