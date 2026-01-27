package com.vastpro.onlineexam.command;

import java.util.List;

import com.vastpro.onlineexam.dao.LoadRetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: LoadRetireExamCommand
 *
 * Description:
 * This command class is responsible for loading all retired exams
 * from the database and setting them as a request attribute.
 *
 * It implements the Command interface and interacts with the
 * LoadRetireExamDAO to fetch data.
 */
public class LoadRetireExamCommand implements Command {

    /**
     * Executes the command to load all retired exams.
     *
     * @param req the HttpServletRequest object, where the list of retired exams
     *            will be set as a request attribute named "retiredExam"
     * @param res the HttpServletResponse object
     * @return true if exams were loaded successfully and set in request attribute,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		boolean flag = false;
		try {
			List<String> retiredExam = LoadRetireExamDAO.loadAllRetiredExam();

			System.out.println("LoadRetireExam retiredExam: " + retiredExam);

			req.setAttribute("retiredExam", retiredExam);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

}
