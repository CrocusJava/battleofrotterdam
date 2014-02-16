package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolCookie;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandWasApprovedRegistration implements Command {

	@EJB
	private UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private ToolMD5 toolMD5;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String approveRegistrationMessage = textBean.findLocaleTextByKey(
				Constants.TEXT_MESSAGE_APPROVEREGISTRATION_FALSE,
				toolCookie.getLocaleName(request));
		boolean allRight = false;

		Integer userId = (Integer) request.getSession().getAttribute(
				Constants.PARAMETER_SESSION_IDUSER);

		if (userId != null) {
			approveRegistrationMessage = textBean.findLocaleTextByKey(
					Constants.TEXT_MESSAGE_APPROVEREGISTRATION_TRUE,
					toolCookie.getLocaleName(request));
			allRight = true;
		}

		JsonObject jsonObjectResponse = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_APPROVE_REGISTRATION, allRight)
				.add(Constants.PARAMETER_APPROVEREGISTRATIONMESSAGE,
						approveRegistrationMessage).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
