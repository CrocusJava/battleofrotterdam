package com.battleweb.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleweb.controller.commands.Command;

/**
 * @author rtkachuk
 * 
 */
@WebServlet(name = "Controller", urlPatterns = { "/controller" })
public class Controller extends HttpServlet {

	@EJB 
	private CommandRequest commandRequest;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String responseString = null;
		try {
			Command command = commandRequest.getCommand(request);
			responseString = command.execute(request, response);
		} catch (ServletException e) {
			//TODO Add logger
			e.printStackTrace();
		}
		if (null!=responseString){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(responseString);
			dispatcher.forward(request, response);
		}
		
	}

}
