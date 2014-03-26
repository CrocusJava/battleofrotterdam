package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolEmail;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandSendComplaint implements Command {

	@EJB
	private TextBean textBean;
	@EJB
	private ToolEmail toolEmail;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String projectId = jsonObjectRequest
				.getString(Constants.PARAMETER_PROJECT_ID);

		StringBuilder message = new StringBuilder();
		message.append("User ")
				.append(toolSession.getUser(request).getLogin())
				.append(" complained about the project: ")       //TODO in DB.
				.append("http://edu.bionic-university.com:1120/battleWEB/single_project.html#projectid=")
				.append(projectId);

		toolEmail.send("Complaint", message.toString(),
				"battleofrotterdam@gmail.com");
		return null;
	}
}
