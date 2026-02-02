package com.vastpro.onlineexam.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vastpro.onlineexam.dao.CreateExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: CreateCommand
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
		String exam_topic = request.getParameter("exam_topic");
		String exam_name = request.getParameter("exam_name");
		String description = request.getParameter("description");
		String add_question = request.getParameter("add_question");
		String pass_min_correct = request.getParameter("pass_min_correct");
		String each_question_mark = request.getParameter("each_question_mark");
		String durationStr = request.getParameter("duration_minutes");
		String rollId = request.getParameter("role_id");

		
		if(exam_topic == null || !exam_topic.matches("^[a-zA-Z]+$")) {
			request.setAttribute("examTopicError", "Invalid Exam Topic");
			return false;
		}
		if(exam_name == null || !exam_name.matches("^[a-zA-Z]+$")) {
			request.setAttribute("examNameError", "Invalid Exam Name");
			return false;
		}
		if(description == null || !description.matches("^[a-zA-Z]+$")) {
			request.setAttribute("descriptionError", "Invalid Description");
			return false;
		}
		if(add_question == null || !add_question.matches("^[0-9]+$")) {
			request.setAttribute("addQuestionError", "Invalid.Please provide a valid number");
			return false;
		}
		if(pass_min_correct == null || !pass_min_correct.matches("^[0-9]+$")) {
			request.setAttribute("minCorrectError", "Invalid.Please provide a valid minimum correct mark");
			return false;
		}
		if(each_question_mark == null || !each_question_mark.matches("^[0-9]+$")) {
			request.setAttribute("eachQuestionMarkError", "Invalid.Please provide a valid marks");
			return false;
		}
		int durationMinutes = 0;
		if (durationStr == null || !durationStr.matches("^[1-9][0-9]*$")) {
		    request.setAttribute("durationMinError", "Invalid exam duration");
		    return false;
		}

		durationMinutes = Integer.parseInt(durationStr);
		
		if (!CreateExamDAO.checkExamAvailable(request)) {

			return CreateExamDAO.createExam(request);
		}
		request.setAttribute("examError", "Already Exam Available");
		return false;
		
		
	}
	
	
	

}
