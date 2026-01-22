package com.vastpro.onlineexam.command;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DummyClass implements Command{

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return true;
//		RequestDispatcher rd = req.getRequestDispatcher("con")
	}
	
}
