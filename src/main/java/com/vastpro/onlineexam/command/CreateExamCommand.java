package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: CreateExamCommand
 *
 * Description: This class is responsible for handling the creation of a new exam.
 *
 * It implements the Command interface and delegates the actual creation logic to the CreateExamDAO class.
 */
public class CreateExamCommand implements Command {

	/**
	 * Executes the command to create a new exam.
	 *
	 * @param request
	 *            the HttpServletRequest object containing exam details
	 * @param response
	 *            the HttpServletResponse object
	 * @return true if the exam is created successfully, false otherwise
	 */
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		String examTopic = request.getParameter("exam_topic");
		String examName = request.getParameter("exam_name");
		String description = request.getParameter("description");
		String noOfQuestion = request.getParameter("no_of_question");
		String passMinimumCorrect = request.getParameter("pass_min_correct");
		String durationStr = request.getParameter("duration_minutes");

		if (examTopic == null || !examTopic.matches("^[a-zA-Z0-9 ,._]+$")) {
			request.setAttribute("examTopicError", "Invalid Exam Topic");
			return false;
		}
		if (examName == null || !examName.matches("^[a-zA-Z0-9 ,._]+$")) {
			request.setAttribute("examNameError", "Invalid Exam Name");
			return false;
		}
		if (description == null || !description.matches("^[a-zA-Z0-9 ,._]+$")) {
			request.setAttribute("descriptionError", "Invalid Description");
			return false;
		}
		if (noOfQuestion == null || !noOfQuestion.matches("^[1-9][0-9]*$")) {
			request.setAttribute("addQuestionError", "Invalid.Please provide a valid number");
			return false;
		}
		if (passMinimumCorrect == null || !passMinimumCorrect.matches("^[1-9][0-9]*$")) {
			request.setAttribute("minCorrectError", "Invalid.Please provide a valid minimum correct mark");
			return false;
		}

		if (durationStr == null || !durationStr.matches("^[1-9][0-9]*$")) {
			request.setAttribute("durationMinError", "Invalid exam duration");
			return false;
		}

		if (!CreateExamDAO.checkExamAvailable(request)) {

			return true;
					
		}
		request.setAttribute("examError", "Already Exam Available");
		return false;

	}

}
