package com.vastpro.onlineexam.command;

import java.util.List;

import com.vastpro.onlineexam.dao.LoadActiveExamDAO;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoadActiveExamCommand implements Command {
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		boolean flag = false;
		try {
			List<String> activeExam = LoadActiveExamDAO.loadAllActiveExam();

			System.out.println("LoadActiveExam activeExam: " + activeExam);

			req.setAttribute("activeExam", activeExam);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

}
