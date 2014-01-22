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
public class CommandCompetitions implements Command {

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
		String orderBy = Constants.ORDER_BY_START_DATE;
		String sort = "";
		String name = null;
		Date startDateFrom = null;
		Date startDateTo = null;
		Date endDateFrom = null;
		Date endDateTo = null;
		Date regDeadlineFrom = null;
		Date regDeadlineTo = null;
		Integer id = null;
		String type = null;
		boolean showDescription = true;
		Integer winnerId = null;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd MMMM yyyy HH:mm", Locale.ENGLISH);

		try {
			orderBy = jsonObjectRequest.getString(Constants.PARAMETER_ORDER_BY);
		} catch (NullPointerException e) {
		}
		try {
			sort = jsonObjectRequest.getString(Constants.PARAMETER_SORT);
		} catch (NullPointerException e) {
		}
		try {
			showDescription = jsonObjectRequest
					.getBoolean(Constants.PARAMETER_SHOW_DESCRIPTION);
		} catch (NullPointerException e) {
		}
		try {
			JsonObject jsonFilter = jsonObjectRequest
					.getJsonObject(Constants.PARAMETER_FILTER);

			try {
				name = jsonFilter.getString(Constants.PARAMETER_NAME);
			} catch (NullPointerException e) {
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_START_DATE_FROM);
				startDateFrom = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_START_DATE_TO);
				startDateTo = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_END_DATE_FROM);
				endDateFrom = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_END_DATE_TO);
				endDateTo = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_REG_DEADLINE_FROM);
				regDeadlineFrom = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonFilter
						.getString(Constants.PARAMETER_REG_DEADLINE_TO);
				regDeadlineTo = format.parse(date);
			} catch (NullPointerException e) {
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				id = jsonFilter.getInt(Constants.PARAMETER_ID);
			} catch (NullPointerException e) {
			}
			try {
				type = jsonFilter.getString(Constants.PARAMETER_TYPE);
			} catch (NullPointerException e) {
			}
			try {
				winnerId = jsonFilter.getInt(Constants.PARAMETER_WINNER_ID);
			} catch (NullPointerException e) {
			}
		} catch (NullPointerException e) {
		}

		List<Competition> competitions = competitionBean
				.findFilterOrderByDateLimit(orderBy, name, sort, startDateFrom,
						startDateTo, endDateFrom, endDateTo, regDeadlineFrom,
						regDeadlineTo, id, winnerId, type, firstPosition, size);

		JsonArrayBuilder jsonCompetitionsArrayBuilder = Json
				.createArrayBuilder();
		for (Competition competition : competitions) {

			User user = competition.getUser();

			JsonObjectBuilder jsonUserBuilder = Json.createObjectBuilder();
			if (user != null) {
				jsonUserBuilder
						.add(Constants.PARAMETER_ID, user.getId())
						.add(Constants.PARAMETER_FIRSTNAME, user.getFirstname())
						.add(Constants.PARAMETER_LASTNAME, user.getLastname())
						.add(Constants.PARAMETER_MIDDLENAME,
								user.getMiddlename())
						.add(Constants.PARAMETER_LOGIN, user.getLogin())
						.add(Constants.PARAMETER_AVATAR_PATH,
								user.getPhotoPath());
			}
			JsonObject jsonUser = jsonUserBuilder.build();

			JsonObjectBuilder jsonProjectBuilder = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, competition.getId())
					.add(Constants.PARAMETER_NAME, competition.getName())
					.add(Constants.PARAMETER_TYPE,
							competition.getType().getName())
					.add(Constants.PARAMETER_START_DATE,
							dateFormat.format(competition.getDateStart()))
					.add(Constants.PARAMETER_END_DATE,
							dateFormat.format(competition.getDateEnd()))
					.add(Constants.PARAMETER_REG_DEADLINE,
							dateFormat.format(competition.getRegisterDeadline()))
					.add(Constants.PARAMETER_WINNER, jsonUser);
			if (showDescription) {
				jsonProjectBuilder.add(Constants.PARAMETER_DESCRIPTION,
						competition.getDescription());
			}

			jsonCompetitionsArrayBuilder.add(jsonProjectBuilder.build());
		}

		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder().add(
				Constants.PARAMETER_COMPETITIONS, jsonCompetitionsArrayBuilder);

		toolJSON.setJsonObjectResponse(response, jsonObjectBuilder.build());

		return null;

	}
}
