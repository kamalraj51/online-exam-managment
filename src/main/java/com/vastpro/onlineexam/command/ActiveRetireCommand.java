package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ActiveRetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: ActiveRetireCommand
 *
 * Description: This class is responsible for update exam status active/retire
 *
 */
public class ActiveRetireCommand implements Command {

	/**
	 * Executes the change status.
	 *
	 * @param request
	 *            the HttpServletRequest object
	 * @param response
	 *            the HttpServletResponse object
	 * @return true if the status is changed to active or retire false otherwise.
	 */
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {

		return ActiveRetireExamDAO.activeRetireExam(request);
	}

}
