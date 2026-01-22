package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateAnswerDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AnswerCommand implements Command{

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return CreateAnswerDAO.addAnswer(req);
	}
	
}
