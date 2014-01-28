package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolCookie;
import com.battleweb.tools.ToolJSON;

/**
 * 
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandLocale implements Command {

	@EJB
	private ToolCookie toolCookie;
	@EJB
	private ToolJSON toolJSON;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String locale = jsonObjectRequest.getString(Constants.PARAMETER_LOCALE);
		toolCookie.changeLocale(request, locale);
		return null;
	}
}
