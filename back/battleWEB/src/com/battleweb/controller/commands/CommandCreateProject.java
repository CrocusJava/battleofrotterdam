package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import com.battleejb.entities.Competition;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolCookie;
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
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectResponse = null;

		if (toolSession.getUser(request) != null) {
			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);
			String type = jsonObjectRequest.getString(Constants.PARAMETER_TYPE);
			Date currentDate = new Date();
			Competition competition = competitionBean
					.findFilterOrderByDateLimit("startdate", null, null, null,
							currentDate, null, null, currentDate, null, null,
							null, type, 0, 1).get(0);

			User user = userBean.find(Integer.parseInt(request.getSession()
					.getAttribute(Constants.PARAMETER_SESSION_IDUSER)
					.toString()));

			List<Project> projects = projectBean
					.findFilterOrderByDateOrRatingLimit("date", "desc",
							user.getLogin(), null, null, null,
							competition.getId(), null, 0, 1, null);

			if (projects == null || projects.isEmpty()) {

				String name = jsonObjectRequest
						.getString(Constants.PARAMETER_NAME);
				String description = jsonObjectRequest
						.getString(Constants.PARAMETER_DESCRIPTION);

				Project project = new Project();
				project.setName(name);
				project.setDescription(description);
				project.setCreationDate(new Date());
				project.setCompetition(competition);
				project.setUser(user);
				project.setApproved(false);

				if (name != null && project.getCompetition() != null) {

					projectBean.create(project);

					String cteateProjectMessage = textBean.findLocaleTextByKey(
							Constants.TEXT_MESSAGE_CREATE_PROJECT,
							toolCookie.getLocaleName(request));

					jsonObjectResponse = Json
							.createObjectBuilder()
							.add(Constants.PARAMETER_PROJECT_ID,
									project.getId())
							.add(Constants.PARAMETER_CREATE_PROJECT_MESSAGE,
									cteateProjectMessage).build();
				}
			} else {
				jsonObjectResponse = Json
						.createObjectBuilder()
						.add(Constants.PARAMETER_MESSAGE,
								"User already has a project in this competition")
						.build();
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
