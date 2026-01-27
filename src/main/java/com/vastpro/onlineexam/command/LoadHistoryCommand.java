package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ExamHistoryDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: LoadHistoryCommand
 *
 * Description:
 * This command class is responsible for loading the exam history
 * for a specific user.
 *
 * It implements the Command interface and delegates the retrieval
 * of exam history to the ExamHistoryDAO.
 */
public class LoadHistoryCommand implements Command {

    /**
     * Executes the command to retrieve exam history for the current user.
     *
     * @param req  the HttpServletRequest object, containing the session with user_id
     * @param res  the HttpServletResponse object
     * @return true if exam history is successfully retrieved and set as request attributes,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return ExamHistoryDAO.getExamsHistoryByUserId(req);
	}

}
