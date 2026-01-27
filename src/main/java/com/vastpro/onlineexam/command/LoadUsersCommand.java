package com.vastpro.onlineexam.command;

import com.vastpro.onlineexam.dao.ListUserBasedHistoryDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Class Name: LoadUsersCommand
 *
 * Description:
 * This command class is responsible for loading all users with role_id=2
 * (typically students) and their exam history.
 *
 * It implements the Command interface and delegates the retrieval of data
 * to ListUserBasedHistoryDAO.
 */
public class LoadUsersCommand implements Command{

	 /**
     * Executes the command to load users and their exam histories.
     *
     * @param req the HttpServletRequest object where user list and history
     *            will be set as request attributes "userList" and "userBasedHistory"
     * @param res the HttpServletResponse object
     * @return true if user list and history are successfully retrieved and set in request,
     *         false otherwise
     */
	@Override
	public boolean execute(HttpServletRequest req, HttpServletResponse res) {
		return ListUserBasedHistoryDAO.getAllUsers(req);
		
	}

}
