package com.vastpro.onlineexam.command;

import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.dao.CreateNewUser;
import com.vastpro.onlineexam.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
	static List<User> userDetail = new ArrayList<User>();

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("register called");
		return CreateNewUser.registerUser(req);

	}

}
