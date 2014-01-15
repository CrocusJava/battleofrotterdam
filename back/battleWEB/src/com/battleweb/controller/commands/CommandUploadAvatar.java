package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleweb.tools.ToolSession;
import com.battleweb.tools.ToolUpload;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandUploadAvatar implements Command {

	@EJB
	ToolUpload toolUpload;
	
	@EJB
	ToolSession toolSession;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		return null;

	}

}
