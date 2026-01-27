package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ActiveExamDAO;
import com.vastpro.onlineexam.dao.RetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: ActiveExamCommand
 *
 * Description:
 * This class is used to activate an exam by calling
 * the ActiveExamDAO layer.
 *
 * It implements the Command interface and processes
 * the request to make an exam active.
 */
public class ActiveExamCommand implements Command{
	
	 /**
     * Executes the command to activate an exam.
     *
     * @param req the HttpServletRequest object containing exam_name
     * @param res the HttpServletResponse object
     * @return true if the exam is activated successfully,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
	System.out.println("ActiveExamCommand called");
		return ActiveExamDAO.activeExam(req);
	}
}
