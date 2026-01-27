package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ListExamBasedHistoryDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: LoadExamCommand
 *
 * Description:
 * This command class is responsible for loading exam-based history data.
 * It delegates the actual database operation to ListExamBasedHistoryDAO.
 *
 * It follows the Command design pattern.
 */
public class LoadExamCommand implements Command {

    /**
     * Executes the command to load exam-based history.
     *
     * @param req HttpServletRequest containing request parameters
     *            (like selected exam ID)
     * @param res HttpServletResponse object
     * @return true if data is loaded successfully,
     *         false if any error occurs
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return ListExamBasedHistoryDAO.getAllUsers(req);
	}

}
