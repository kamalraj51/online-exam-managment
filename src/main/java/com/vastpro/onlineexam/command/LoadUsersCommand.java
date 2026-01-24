package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ListUserBasedHistoryDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoadUsersCommand implements Command{

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return ListUserBasedHistoryDAO.getAllUsers(req);
		
	}

}
