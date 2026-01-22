package com.vastpro.onlineexam.command;

import java.util.ArrayList;

import java.util.List;

import com.vastpro.onlineexam.dao.CreateNewUserDAO;
import com.vastpro.onlineexam.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
	static List<UserDTO> userDetail = new ArrayList<UserDTO>();

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("register called");
		return CreateNewUserDAO.registerUser(req);

	}

}
