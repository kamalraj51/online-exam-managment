package com.vastpro.onlineexam.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vastpro.onlineexam.command.Command;
import com.vastpro.onlineexam.command.CommandFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Name: ControllerServlet
 *
 * Description: This servlet acts as the central controller for the Online Exam system. It handles all incoming requests with an "action"
 * parameter, delegates the request to the corresponding Command class, and forwards the response to the appropriate JSP page based on
 * success or failure.
 *
 * Responsibilities: 1. Read the "action" parameter from the request. 2. Retrieve the corresponding Command object from CommandFactory. 3.
 * Execute the Command. 4. Forward the request to the configured success or failure view.
 */
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ControllerServlet.class);

	/**
	 * Default constructor.
	 */
	public ControllerServlet() {

	}

	/**
	 * Handles HTTP GET requests. Delegates the request to the appropriate Command object and forwards to the configured JSP page.
	 *
	 * @param request
	 *            the HttpServletRequest object containing client request data
	 * @param response
	 *            the HttpServletResponse object for sending response to the client
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			logger.debug("ControllerServlet doGet() called");

			String action = request.getParameter("action");
	
			
			if (action == null || action.trim().isEmpty()) {
	            logger.error("Action parameter is missing");
	            request.setAttribute("errorMessage", "Invalid request. Action is missing.");
	            request.getRequestDispatcher("/login_view/error.jsp").forward(request, response);
	            return;
	        }
			action = action.toLowerCase();
			logger.info("Received action: {}", action);

			Command command = CommandFactory.getCommand(action);
			if (command == null) {
		            logger.error("No command found for action: {}", action);
		            request.setAttribute("errorMessage", "Requested operation is not supported.");
		            request.getRequestDispatcher("/login_view/error.jsp").forward(request, response);
		            return;
		        }
			boolean flag = command.execute(request, response);
			logger.debug("Command execution result for {}: {}", action, flag);

			String forward;
			if (flag) {
				forward = CommandFactory.configMap.get(action).getSuccess();
				logger.info("Forwarding to success page: {}", forward);
			} else {
				forward = CommandFactory.configMap.get(action).getFailure();
				logger.warn("Forwarding to failure page: {}", forward);
			}

			request.getRequestDispatcher(forward).forward(request, response);

		} catch (Exception e) {
			logger.error("Unhandled exception in ControllerServlet", e);

	        request.setAttribute("errorMessage",
	                "System error occurred. Please contact administrator.");

	        request.getRequestDispatcher("/login_view/error.jsp")
	               .forward(request, response);
		}
	}

	/**
	 * Handles HTTP POST requests. Delegates the POST request to doGet method.
	 *
	 * @param request
	 *            the HttpServletRequest object containing client request data
	 * @param response
	 *            the HttpServletResponse object for sending response to the client
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
