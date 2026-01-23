package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ListExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectExamCommand implements Command {
	static String topic;
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		
		topic = req.getParameter("userSelectedOption");
		System.out.println("SelectExamCommand topic: "+topic);
		
		return ListExamDAO.getActiveExams(req);
	}
}
