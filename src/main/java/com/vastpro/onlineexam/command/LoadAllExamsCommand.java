package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.LoadAllExamsDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoadAllExamsCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return LoadAllExamsDAO.getAllExams(req);
	}

}
