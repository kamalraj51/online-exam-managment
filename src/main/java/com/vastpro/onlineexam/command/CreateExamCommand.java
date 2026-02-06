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
		/*
		 * if (examTopic == null || !examTopic.matches("^[a-zA-Z0-9 _\\-.,:]{3,}$")) { request.setAttribute("examTopicError",
		 * "Enter a valid topic more than 3 characters"); return false; } if (examName == null ||
		 * !examName.matches("^[a-zA-Z0-9 _\\-.,:]{3,}$")) { request.setAttribute("examNameError",
		 * "Enter a valid exam name more than 3 characters"); return false; } if (description == null ||
		 * !description.matches("^[a-zA-Z0-9 _\\-.,:]{3,}$")) { request.setAttribute("descriptionError",
		 * "Enter a description,must contain atleast 3 characters"); return false; } if (noOfQuestion == null ||
		 * !noOfQuestion.matches("^(?:[1-9]|1[0-9]|20)$")) { request.setAttribute("addQuestionError", "Enter a valid number 1-20"); return
		 * false; } if (passMinimumCorrect == null || !passMinimumCorrect.matches("^(?:[1-9]|1[0-9]|100)$")) {
		 * request.setAttribute("minCorrectError", "Enter a valid percentage 1-100"); return false; }
		 * 
		 * if (durationStr == null || !durationStr.matches("^(?:[1-9]|1[0-9]|180)$")) { request.setAttribute("durationMinError",
		 * "Enter a valid time in minutes less than 180 minutes"); return false; }
		 */
		if (!CreateExamDAO.checkExamAvailable(request)) {

			return true;

		}
		request.setAttribute("examError", "Already Exam Available");
		return false;

	}

}
