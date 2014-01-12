package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;


/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandCurrentRankings implements Command {


	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//code here...

		return null;
	}
}
