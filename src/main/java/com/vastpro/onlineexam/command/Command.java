package com.vastpro.onlineexam.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Interface Name: Command
 *
 * Description:
 * This interface defines a common contract for all command classes
 * in the application.
 *
 * Each command class implements this interface to process a specific
 * user request and perform the corresponding business logic.
 *
 * The execute method returns a boolean value to indicate whether
 * the operation was successful or not, which is used to decide
 * navigation flow (success or failure).
 */
public interface Command {
	
	/**
     * Executes a specific command operation.
     *
     * @param req the HttpServletRequest object containing request data
     * @param res the HttpServletResponse object used for response handling
     * @return true if the command executes successfully,
     *         false otherwise
     */
	boolean execute(HttpServletRequest req, HttpServletResponse res);
	 
}
