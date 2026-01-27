package com.vastpro.onlineexam.command;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: DummyClass
 *
 * Description:
 * This is a placeholder command class that implements the Command interface.
 * 
 * It is used in the configuration for actions where no specific processing
 * logic is required, but a command object is still needed.
 *
 * Typically used for simple page navigation without any business logic.
 */
public class DummyClass implements Command{

    /**
     * Executes the dummy command.
     *
     * @param req the HttpServletRequest object
     * @param res the HttpServletResponse object
     * @return always returns true, indicating success
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return true;
	}
	
}
