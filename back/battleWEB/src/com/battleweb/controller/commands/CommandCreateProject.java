package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;

import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Project;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandCreateProject implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private CompetitionBean competitionBean;
	@EJB
	private UserBean userBean;
	@EJB
	private TextBean textBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectResponse = null;

		if (toolSession.getUser(request) != null) {

			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);
			String name = jsonObjectRequest.getString(Constants.PARAMETER_NAME);
			String description = jsonObjectRequest
					.getString(Constants.PARAMETER_DESCRIPTION);
			int competitionId = jsonObjectRequest
					.getInt(Constants.PARAMETER_COMPETITION_ID);

			Project project = new Project();
			project.setName(name);
			project.setDescription(description);
			project.setCreationDate(new Date());
			project.setCompetition(competitionBean.find(competitionId));
			project.setUser(userBean.find(Integer.parseInt(request.getSession()
					.getAttribute(Constants.PARAMETER_SESSION_IDUSER)
					.toString())));
			project.setApproved(true);

			if (name != null && project.getCompetition() != null) {

				projectBean.create(project);

				String cteateProjectMessage = textBean.findLocaleTextByKey(
						Constants.TEXT_MESSAGE_CREATE_PROJECT,
						request.getLocale());

				jsonObjectResponse = Json
						.createObjectBuilder()
						.add(Constants.PARAMETER_PROJECT_ID, project.getId())
						.add(Constants.PARAMETER_CREATE_PROJECT_MESSAGE,
								cteateProjectMessage).build();
			}

		} else {
			jsonObjectResponse = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_MESSAGE,
							"Invocation without authorization").build();
		}

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
