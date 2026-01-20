package com.vastpro.onlineexam.controller;

import java.io.IOException;

import com.vastpro.onlineexam.command.Command;
import com.vastpro.onlineexam.command.CommandFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final Logger logger=LogManager.getLogger(ControllerServlet.class);
    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
//		String username=request.getParameter("user");
		//System.out.println("Logger: "+logger.toString());
		System.out.println(action);
		//logger.error("error");
		//logger.warn("warning");
	//	logger.debug("action:{}",action);
//		logger.debug("username:{}",username);
//		if(action==null) {
//			logger.info("Action is missing");
//		}
		Command command=CommandFactory.getCommand(action);
		//logger.info("Command Object=="+command);
		boolean flag=command.execute(request, response);
		if(flag) {
			String forward=CommandFactory.configMap.get(action).getSuccess();
			request.getRequestDispatcher(forward).forward(request, response);
		}else {
			String forward=CommandFactory.configMap.get(action).getFailure();
			request.getRequestDispatcher(forward).forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
