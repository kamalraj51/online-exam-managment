package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ExamHistoryDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoadHistoryCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return ExamHistoryDAO.getExamsHistoryByUserId(req);
	}

}
