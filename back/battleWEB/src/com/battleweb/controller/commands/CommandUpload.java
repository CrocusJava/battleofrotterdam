package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandUpload implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


}
