package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ActiveRetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActiveRetireCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {

		return ActiveRetireExamDAO.activeRetireExam(req);
	}

}
