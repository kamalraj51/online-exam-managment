package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.CreateExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		
		return CreateExamDAO.createExam(request);
		//return ExampleDAO.createExam(request);
	}

}
