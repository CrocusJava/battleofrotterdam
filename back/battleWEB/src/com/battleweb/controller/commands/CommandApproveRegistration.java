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
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandApproveRegistration implements Command {

	@EJB
	private UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private ToolMD5 toolMD5;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String approveRegistrationMessage = textBean.findLocaleTextByKey(
				Constants.TEXT_MESSAGE_APPROVEREGISTRATION_FALSE,
				request.getLocale());

		Integer userId = Integer.parseInt(request
				.getParameter(Constants.PARAMETER_IDUSER));
		String value = request.getParameter("value");

		User user = userBean.find(userId);

		if (value.equals(toolMD5.generateMD5(user.getLogin()))) {
			user.setApproveregistration(true);
			userBean.edit(user);
			approveRegistrationMessage = textBean.findLocaleTextByKey(
					Constants.TEXT_MESSAGE_APPROVEREGISTRATION_TRUE,
					request.getLocale());
		}

		JsonObject jsonObjectResponse = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_APPROVEREGISTRATIONMESSAGE,
						approveRegistrationMessage).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;//here require redirect, because user came from email; Ruslan, set the page.
	}
}
