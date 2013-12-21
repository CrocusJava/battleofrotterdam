package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Address;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolEmail;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
public class CommandForgotPassword implements Command {

	@EJB
	private UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolMD5 toolMD5;
	@EJB
	private ToolEmail toolEmail;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String newPasswordMessage = "blabla chack your email..";

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String email = jsonObjectRequest.getString(Constants.PARAMETER_EMAIL);

		User user = (User) request.getSession().getAttribute("user");

		String newPassword = user.getPassword().substring(0, 7);
		user.setPassword(toolMD5.generateMD5(newPassword));
		userBean.edit(user);

		StringBuilder message = new StringBuilder();
		message.append("Your new password: ");
		message.append(newPassword);

		toolEmail.send("Battle of Rotterdam new password", message.toString(),
				"battleofrotterdam@gmail.com", email);

		JsonObject jsonObjectResponse = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_EMAIL, email)
				.add(Constants.PARAMETER_NEWPASSWORDMESSAGE,
						newPasswordMessage).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
