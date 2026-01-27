package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ListExamBasedHistoryDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoadExamCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return ListExamBasedHistoryDAO.getAllUsers(req);
	}

}
