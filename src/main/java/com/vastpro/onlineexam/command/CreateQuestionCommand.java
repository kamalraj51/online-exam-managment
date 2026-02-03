package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateQuestionDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: AddQueationCommand
 *
 * Description: This class is used to create a questions and answers calling the CreateQuestionDAO layer.
 *
 * It implements the Command interface and processes the request to create questions and answers.
 */
public class CreateQuestionCommand implements Command {

	/**
	 * Executes the command to create questions and answers.
	 *
	 * @param req
	 *            the HttpServletRequest object containing the exam Id, mark, question text and and question number in session
	 * @param res
	 *            the HttpServletResponse object
	 * @return true if the questions successfully inserted, false otherwise
	 */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {

		int noOfQuestions = (Integer) req.getSession().getAttribute("noOfQuestions");
		for (int i = 1; i <= noOfQuestions; i++) {

			String question_id = req.getParameter("question_id" + i);
			String marks = req.getParameter("marks" + i);
			String option_1 = req.getParameter("option_1" + i);
			String option_2 = req.getParameter("option_2" + i);
			String option_3 = req.getParameter("option_3" + i);
			String option_4 = req.getParameter("option_4" + i);

			if (question_id == null || !question_id.matches("^[a-zA-Z0-9 ,._]{5,200}$")) {
				req.setAttribute("questionError", "Invalid question, question must contain 5 characters");
				return false;
			}

			if (option_1 == null || !option_1.matches("^[a-zA-Z0-9 ,._]+$")) {
				req.setAttribute("option1_error", "Invalid option A");
				return false;
			}

			if (option_2 == null || !option_2.matches("^[a-zA-Z0-9 ,._]+$")) {
				req.setAttribute("option2_error", "Invalid option B");
				return false;
			}

			if (option_3 == null || !option_3.matches("^[a-zA-Z0-9 ,._]+$")) {
				req.setAttribute("option3_error", "Invalid option C");
				return false;
			}

			if (option_4 == null || !option_4.matches("^[a-zA-Z0-9 ,._]+$")) {
				req.setAttribute("option4_error", "Invalid option D");
				return false;
			}
		}

		boolean isCreated = CreateQuestionDAO.addQuestion(req);
		if (isCreated) {
			req.getSession().setAttribute("adminToastStatus", "success");
			req.getSession().setAttribute("adminToast", "exam created successfully!");
			return true;
		} else {
			req.getSession().setAttribute("questionToastStatus", "failed");
			req.getSession().setAttribute("questionToast", "exam creation faild!");
			return false;
		}
	}

}
