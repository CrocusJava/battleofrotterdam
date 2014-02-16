package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolCookie;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandChangeLanguage implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String locale = jsonObjectRequest.getString(Constants.PARAMETER_LOCALE);
		
		Log.info(this, "User tries to change the language on - "+ locale);
		toolCookie.changeLocale(request, locale);
		Log.info(this, "User has successfully changed the language on - "+ locale);
		
		return null;
	}
}
