package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ActiveExamDAO;
import com.vastpro.onlineexam.dao.RetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActiveExamCommand implements Command{
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
	System.out.println("ActiveExamCommand called");
		return ActiveExamDAO.activeExam(req);
	}
}
