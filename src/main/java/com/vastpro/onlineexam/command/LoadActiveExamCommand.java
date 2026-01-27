package com.vastpro.onlineexam.command;

import java.util.List;

import com.vastpro.onlineexam.dao.LoadActiveExamDAO;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Class Name: LoadActiveExamCommand
 *
 * Description:
 * This command class is responsible for loading all active exams
 * from the database and setting them as a request attribute.
 *
 * It implements the Command interface and interacts with the
 * LoadActiveExamDAO to fetch data.
 */
public class LoadActiveExamCommand implements Command {
	 /**
     * Executes the command to load all active exams.
     *
     * @param req the HttpServletRequest object, where the list of active exams
     *            will be set as a request attribute named "activeExam"
     * @param res the HttpServletResponse object
     * @return true if exams were loaded successfully, false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		boolean flag = false;
		try {
			List<String> activeExam = LoadActiveExamDAO.loadAllActiveExam();

			System.out.println("LoadActiveExam activeExam: " + activeExam);

			req.setAttribute("activeExam", activeExam);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

}
