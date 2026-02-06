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
		if (username == null || username.trim().isEmpty()) {
			req.setAttribute("nameError", "Username cannot be empty");
			return flag;
		}
		if (!username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$")) {
			req.setAttribute("nameError", "Username must contain letters or numbers");
			return flag;
		}

		if (email == null  || email.trim().isEmpty() || !email.matches("^[^\\s@]+@[^.\\s@]*[a-zA-Z][^.\\s@]*\\.[a-zA-Z]{2,}$")) {
			req.setAttribute("emailError", "Invalid email. Please provide a valid email address.");
			return flag;
		}

		// Password validation (min 8 chars, uppercase, lowercase, number)
		if (password == null || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")) { 
			req.setAttribute("passwordError", "Password must contain at least 8 characters long");
			return flag;
		}

		// All validations passed, proceed with user registration

		if (!RegisterDAO.checkUser(req)) {
			boolean isRegistered = RegisterDAO.registerUser(req);

			if (isRegistered) {

				req.getSession().setAttribute("createAccToast", "Account created successfully!");
				flag = true;
			}

		} else {
			req.setAttribute("signupErrorEmail", "User Already Available");
			return flag;
		}

		return flag;
	}

}
