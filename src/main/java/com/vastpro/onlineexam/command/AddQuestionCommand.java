package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateQuestionDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Class Name: AddQueationCommand
 *
 * Description:
 * This class is used to create a questions and answers calling
 * the CreateQuestionDAO layer.
 *
 * It implements the Command interface and processes
 * the request to create questions and answers.
 */
public class AddQuestionCommand implements Command{

	 /**
     * Executes the command to create questions and answers.
     *
     * @param req the HttpServletRequest object containing the exam Id, mark, question text and  and question number in session
     * @param res the HttpServletResponse object
     * @return true if the questions successfully inserted,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return CreateQuestionDAO.addQuestion(req);
	}

}
