package com.vastpro.onlineexam.command;

import java.util.ArrayList;

import java.util.List;

import com.vastpro.onlineexam.dao.CreateNewUserDAO;
import com.vastpro.onlineexam.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Class Name: RegisterCommand
 *
 * Description:
 * This command handles the registration of a new user.
 * It retrieves user details from the request and delegates
 * the registration process to CreateNewUserDAO.
 */
public class RegisterCommand implements Command {
	/**
     * Executes the command to register a new user.
     *
     * @param req the HttpServletRequest object containing
     *            username, password, email, and role ID
     * @param res the HttpServletResponse object
     * @return true if the user is registered successfully,
     *         false otherwise
     */
	static List<UserDTO> userDetail = new ArrayList<UserDTO>();

	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("register called");
		return CreateNewUserDAO.registerUser(req);

	}

}
