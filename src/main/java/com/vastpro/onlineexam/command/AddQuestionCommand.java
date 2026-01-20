package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateQuestionDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddQuestionCommand implements Command{

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return CreateQuestionDAO.addQuestion(req);
	}

}
