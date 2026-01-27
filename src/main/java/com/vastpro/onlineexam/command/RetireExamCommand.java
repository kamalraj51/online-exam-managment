package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.LoadRetireExamDAO;
import com.vastpro.onlineexam.dao.RetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Class Name: RetireExamCommand
 *
 * Description:
 * This command handles the retirement of an exam.
 * It retrieves the exam name from the request and
 * delegates the retirement operation to RetireExamDAO.
 */
public class RetireExamCommand implements Command {
	/**
     * Executes the command to retire an exam.
     *
     * @param req the HttpServletRequest object containing
     *            the exam name to be retired
     * @param res the HttpServletResponse object
     * @return true if the exam is retired successfully,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
	
		return RetireExamDAO.retireExam(req);
	}

}
