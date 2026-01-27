package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ListExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Class Name: SelectExamCommand
 *
 * Description:
 * This class handles the exam topic selection by the user.
 * It retrieves the selected topic from the request and
 * fetches all active exams related to that topic.
 *
 * It implements the Command interface.
 */
public class SelectExamCommand implements Command {
	
	static String topic;
	/**
     * Executes the command to fetch active exams
     * based on the selected exam topic.
     *
     * @param req the HttpServletRequest object containing
     *            the user-selected exam topic
     * @param res the HttpServletResponse object
     * @return true if active exams are fetched successfully,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		
		topic = req.getParameter("userSelectedOption");
		System.out.println("SelectExamCommand topic: "+topic);
		
		return ListExamDAO.getActiveExams(req);
	}
}
