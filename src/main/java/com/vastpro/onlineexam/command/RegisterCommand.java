package com.vastpro.onlineexam.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vastpro.onlineexam.controller.ControllerServlet;
import com.vastpro.onlineexam.dao.RegisterDAO;

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
		boolean flag = false;
		// Retrieve form parameters
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// Username validation (allow only alphabets and numbers)
		if (username == null) {
			req.setAttribute("nameError", "Username cannot be empty");
			return flag;
		}
		if (!username.matches("^[a-zA-Z0-9]+$")) {
			req.setAttribute("nameError", "Username must contain letters or numbers");
			return flag;
		}

		// Email validation (only Gmail allowed)
		if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			req.setAttribute("emailError", "Invalid email. Please provide a valid email address.");
			return flag;
		}

		// Password validation (allow letters, numbers, and special characters with a minimum length of 6)
		if (password == null || !password.matches("^[\\S]{6,}$")) {
			req.setAttribute("passwordError", "Password must be at least 6 characters long");
			return flag;
		}

		// All validations passed, proceed with user registration
		if (!RegisterDAO.checkUser(req)) {
			return RegisterDAO.registerUser(req);
		} else {
			req.setAttribute("signupErrorEmail", "User Already Available");
			return flag;
		}
	}

}
