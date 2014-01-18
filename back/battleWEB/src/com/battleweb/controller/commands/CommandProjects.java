package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandProjects implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private PhotoBean photoBean;
	@EJB
	private CommentBean commentBean;
	@EJB
	private VoiceBean voiceBean;
	@EJB
	private CompetitionBean competitionBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		int firstPosition = jsonObjectRequest
				.getInt(Constants.PARAMETER_FIRST_POSITION);
		int size = jsonObjectRequest.getInt(Constants.PARAMETER_SIZE);
		String orderBy = jsonObjectRequest
				.getString(Constants.PARAMETER_ORDER_BY);
		String sort = "";
		String login = null;
		String name = null;
		Date dateFrom = null;
		Date dateTo = null;
		Integer competitionId = null;
		String competitionType = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd MMMM yyyy HH:mm", Locale.ENGLISH);
		try {
			sort = jsonObjectRequest.getString(Constants.PARAMETER_SORT);
		} catch (NullPointerException e) {
		}
		try {
			JsonObject jsonFilter = jsonObjectRequest
					.getJsonObject(Constants.PARAMETER_FILTER);
			try {
				login = jsonFilter.getString(Constants.PARAMETER_LOGIN);
			} catch (NullPointerException e) {
			}
			try {
				name = jsonFilter.getString(Constants.PARAMETER_NAME);
			} catch (NullPointerException e) {
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_DATE_FROM);
				dateFrom = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonFilter.getString(Constants.PARAMETER_DATE_TO);
				dateTo = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				competitionId = jsonFilter
						.getInt(Constants.PARAMETER_COMPETITION_ID);
			} catch (NullPointerException e) {
			}
			try {
				competitionType = jsonFilter
						.getString(Constants.PARAMETER_COMPETITION_TYPE);
			} catch (NullPointerException e) {
			}
		} catch (NullPointerException e) {
		}
		List<Project> projects = projectBean
				.findFilterOrderByDateOrRatingLimit(orderBy, sort, login, name,
						dateFrom, dateTo, competitionId, competitionType,
						firstPosition, size);

		JsonArrayBuilder jsonProjectsArrayBuilder = Json.createArrayBuilder();
		for (Project project : projects) {

			User user = project.getUser();
			JsonObject jsonUser = Json.createObjectBuilder()
					.add(Constants.PARAMETER_ID, user.getId())
					.add(Constants.PARAMETER_LOGIN, user.getLogin())
					.add(Constants.PARAMETER_AVATAR_PATH, user.getPhotoPath())
					.build();

			Competition competition = project.getCompetition();
			JsonObject jsonCompetition = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, competition.getId())
					.add(Constants.PARAMETER_TYPE,
							competition.getType().getName())
					.add(Constants.PARAMETER_NAME, competition.getName())
					.build();

			JsonObjectBuilder jsonProjectBuilder = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, project.getId())
					.add(Constants.PARAMETER_NAME, project.getName())
					.add(Constants.PARAMETER_CREATION_DATE,
							dateFormat.format(project.getCreationDate()))
					.add(Constants.PARAMETER_RATING,
							voiceBean.getRatingByProject(project))
					.add(Constants.PARAMETER_COMMENT_QUANTITY,
							commentBean.getCountByProjectId(project.getId()))
					.add(Constants.PARAMETER_USER, jsonUser)
					.add(Constants.PARAMETER_COMPETITION, jsonCompetition);

			jsonProjectsArrayBuilder.add(jsonProjectBuilder.build());
		}

		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder().add(
				Constants.PARAMETER_PROJECTS, jsonProjectsArrayBuilder);

		toolJSON.setJsonObjectResponse(response, jsonObjectBuilder.build());

		return null;

	}
}
