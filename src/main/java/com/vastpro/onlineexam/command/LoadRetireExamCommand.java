package com.vastpro.onlineexam.command;

import java.util.List;

import com.vastpro.onlineexam.dao.LoadRetireExamDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoadRetireExamCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		boolean flag = false;
		try {
			List<String> retiredExam = LoadRetireExamDAO.loadAllRetiredExam();

			System.out.println("LoadRetireExam retiredExam: " + retiredExam);

			req.setAttribute("retiredExam", retiredExam);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

}
