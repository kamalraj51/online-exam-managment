package com.vastpro.onlineexam.service;

import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUserService implements Command {
	static List<User> userDetail = new ArrayList<User>();

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("register calles");
		System.out.println("u " + req.getParameter("username") + " p " + req.getParameter("password"));
		if (req.getParameter("username") == "" || req.getParameter("password") == ""
				|| req.getParameter("fullname") == "") {
//			System.out.println(userDetail.get(0).+ " dkjf");
			return false;
		} else {

			userDetail.add(
					new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("email"), req.getParameter("role")));
			return true;
		}

	}

}
