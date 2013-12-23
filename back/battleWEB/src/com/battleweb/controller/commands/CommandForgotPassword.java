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
@Stateless
@LocalBean
public class CommandForgotPassword implements Command {

	@EJB
	private UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolMD5 toolMD5;
	@EJB
	private ToolEmail toolEmail;
	@EJB
	private TextBean textBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String newPasswordMessage = "bla bla bla"; //message if email not exist in the DB;
		boolean emailStatus = false;

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String email = jsonObjectRequest.getString(Constants.PARAMETER_EMAIL);

		User user = (User) userBean.findByEmail(email);

		if (user != null) {
			String newPassword = user.getPassword().substring(0, 7);
			user.setPassword(toolMD5.generateMD5(newPassword));
			userBean.edit(user);

			// this message to the database too!!!
			// **********************************
			StringBuilder message = new StringBuilder();
			message.append("Your new password: ");
			message.append(newPassword);
			// **********************************

			toolEmail.send("Battle of Rotterdam new password",
					message.toString(), "battleofrotterdam@gmail.com", email);
			
			newPasswordMessage = textBean.findLocaleTextByKey(
					Constants.TEXT_MESSAGE_NEW_PASSWORD, request.getLocale());
			emailStatus = true;
		}
		
		JsonObject jsonObjectResponse = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_STATUSMAIL, emailStatus)
				.add(Constants.PARAMETER_EMAIL, email)
				.add(Constants.PARAMETER_NEWPASSWORDMESSAGE, newPasswordMessage)
				.build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
