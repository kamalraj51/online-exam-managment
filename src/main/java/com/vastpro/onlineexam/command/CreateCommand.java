package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: CreateCommand
 *
 * Description:
 * This class is responsible for handling the creation of a new exam.
 *
 * It implements the Command interface and delegates the actual
 * creation logic to the CreateExamDAO class.
 */
public class CreateCommand implements Command {

    /**
     * Executes the command to create a new exam.
     *
     * @param request  the HttpServletRequest object containing exam details
     * @param response the HttpServletResponse object
     * @return true if the exam is created successfully, false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		
		return CreateExamDAO.createExam(request);
		//return ExampleDAO.createExam(request);
	}

}
