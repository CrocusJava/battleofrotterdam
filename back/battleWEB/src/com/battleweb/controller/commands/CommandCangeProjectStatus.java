package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Project;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandCangeProjectStatus implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private TextBean textBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		if (toolSession.isAdmin(request)) {
			boolean state = true;

			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);
			Integer projectId = jsonObjectRequest
					.getInt(Constants.PARAMETER_PROJECT_ID);
			Boolean approved = jsonObjectRequest
					.getBoolean(Constants.PARAMETER_APPROVED);
			
			Project project = projectBean.find(projectId);
			project.setApproved(approved);
			projectBean.edit(project);

			jsonObjectResponseBuilder.add(Constants.PARAMETER_STATUS, state)
					.add(Constants.PARAMETER_MESSAGE,
							textBean.findLocaleTextByKey(
									Constants.TEXT_MESSAGE_ADMIN_EDIT_USER,
									request.getLocale()));
		} else {
			Log.error(this, "Command invoked not by admin");
			jsonObjectResponseBuilder.add(Constants.PARAMETER_ERROR_MESSAGE,
					"Command invoked not by admin");
		}

		toolJSON.setJsonObjectResponse(response,
				jsonObjectResponseBuilder.build());

		return null;

	}
}
