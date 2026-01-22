package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.command.Command;
import com.vastpro.onlineexam.dao.CreateExamDAO;
import com.vastpro.onlineexam.dao.ExampleDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		return CreateExamDAO.createExam(request);
		return ExampleDAO.createExam(request);
	}

}
