package com.vastpro.onlineexam.command;


import com.vastpro.onlineexam.dao.LoginDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{

	@Override
	public boolean execute(HttpServletRequest request ,HttpServletResponse response) {
		return LoginDAO.validateLogin(request);
    }
	

}
