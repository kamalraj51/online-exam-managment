package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.RetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RetireExamCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return RetireExamDAO.retireExam(req);
	}

}
