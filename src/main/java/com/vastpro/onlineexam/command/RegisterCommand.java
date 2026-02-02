package com.vastpro.onlineexam.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vastpro.onlineexam.controller.ControllerServlet;
import com.vastpro.onlineexam.dao.CreateNewUserDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: RegisterCommand
 * <p>
 * Description: This command handles the registration of a new user. It retrieves user details from the request and delegates the
 * registration process to CreateNewUserDAO.
 */
public class RegisterCommand implements Command {
	private static final Logger logger = LogManager.getLogger(ControllerServlet.class);

	/**
	 * Executes the command to register a new user.
	 *
	 * @param req
	 *            the HttpServletRequest object containing username, password, email, and role ID
	 * @param res
	 *            the HttpServletResponse object
	 * @return true if the user is registered successfully, false otherwise
	 */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("register called");

		// Retrieve form parameters
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String rollId = req.getParameter("role_id");

		// Username validation (allow only alphabets and numbers)
		if (username == null) {
			req.setAttribute("nameError", "Username cannot be empty");

			return false;
		}
		if (!isValidUsername(username)) {
			req.setAttribute("nameError", "Username must contain letters or numbers");
			return false;
		}

		// Email validation (only Gmail allowed)
		if (email == null || !isValidEmail(email)) {
			req.setAttribute("emailError", "Invalid email. Please provide a valid email address.");
			return false;
		}

		// Password validation (allow letters, numbers, and special characters with a minimum length of 6)
		if (password == null || !isValidPassword(password)) {
			req.setAttribute("passwordError", "Password must be at least 6 characters long");
			return false;
		}

		// All validations passed, proceed with user registration
		return CreateNewUserDAO.registerUser(req);
	}

	// Helper method for email validation (only Gmail)
	private boolean isValidEmail(String email) {
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		Matcher matcher = emailPattern.matcher(email);
		return matcher.matches();
	}

	// Helper method for username validation (only letters and numbers)
	private boolean isValidUsername(String username) {
		Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher matcher = usernamePattern.matcher(username);
		return matcher.matches();
	}

	// Helper method for password validation (letters, numbers, special characters, minimum length of 6)
	private boolean isValidPassword(String password) {
		Pattern passwordPattern = Pattern.compile("^[\\S]{6,}$");
		Matcher matcher = passwordPattern.matcher(password);
		return matcher.matches();
	}
}
