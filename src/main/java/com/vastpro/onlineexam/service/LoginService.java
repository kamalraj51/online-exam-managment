package com.vastpro.onlineexam.service;

import java.util.List;

import com.vastpro.onlineexam.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginService implements Command{
	static List<User> userDetail = RegisterUserService.userDetail; 
	public static String username = "kamal";
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		boolean flag = false;
		System.out.println("login command called");
		
		for(User e : userDetail) {
		if(req.getParameter("username").equals(e.getUsername())
				&& req.getParameter("password").equals(e.getPassword())) {
			flag = true;
		}
		}
		return flag;
	}

}
