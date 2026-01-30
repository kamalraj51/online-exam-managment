package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.controller.ControllerServlet;
import com.vastpro.onlineexam.dao.CreateNewUserDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Class Name: RegisterCommand
 *
 * Description:
 * This command handles the registration of a new user.
 * It retrieves user details from the request and delegates
 * the registration process to CreateNewUserDAO.
 */
public class RegisterCommand implements Command {
	private static final Logger logger = LogManager.getLogger(ControllerServlet.class); 
	/**
     * Executes the command to register a new user.
     *
     * @param req the HttpServletRequest object containing
     *            username, password, email, and role ID
     * @param res the HttpServletResponse object
     * @return true if the user is registered successfully,
     *         false otherwise
     */

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("register called");
		String email = req.getParameter("email");

        // Gmail-only validation
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            req.setAttribute("error", "Invalid Email");
            return false;
        }
		return CreateNewUserDAO.registerUser(req);

	}

}
